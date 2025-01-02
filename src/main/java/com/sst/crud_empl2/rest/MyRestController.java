package com.sst.crud_empl2.rest;

import com.sst.crud_empl2.Entity.Employee;
import com.sst.crud_empl2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private EmployeeService employeeService;

    @Autowired
    public MyRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name = "employeeId") int id){
        return employeeService.findById(id);
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable(name = "employeeId") int id){
        Employee employee = employeeService.findById(id);
        employeeService.deleteEmployeeById(id);
        return employee.toString();
    }
}
