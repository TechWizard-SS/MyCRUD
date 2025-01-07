package com.sst.crud_empl2.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MySecurityConfiguration {

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        // Создание экземпляра JdbcUserDetailsManager с настройкой подключения к базе данных
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        // Настройка пользовательских SQL-запросов
//        jdbcUserDetailsManager.setUsersByUsernameQuery(
//                "SELECT username, password, enabled FROM userspw WHERE username = ?");
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "SELECT username, authority FROM authorities WHERE username = ?");
//
//        // Возврат настроенного экземпляра JdbcUserDetailsManager
//        return jdbcUserDetailsManager;
//    }


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        manager.setUsersByUsernameQuery("SELECT username, password, enabled FROM usersPW WHERE username = ?");
        manager.setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");
        return manager;
    }





//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        UserDetails user1 = User.builder()
//                .username("user1")
//                .password("{noop}user")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("user2")
//                .password("{noop}user")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//
//        UserDetails user3 = User.builder()
//                .username("user3")
//                .password("{noop}user")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2, user3);
//    }
//
//

    @Bean
    public PasswordEncoder passwordEncoder() {
        // return NoOpPasswordEncoder.getInstance(); // Позволяет использовать пароли без шифрования
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configer -> configer
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
