package com.sst.crud_empl2.Service;


import com.sst.crud_empl2.DAO.EmployeeRepository;
import com.sst.crud_empl2.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElseThrow(() -> new RuntimeException("Employee not found"));
    }


    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
