package com.sst.crud_empl2.Service;

import com.sst.crud_empl2.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteEmployeeById(int id);
}
