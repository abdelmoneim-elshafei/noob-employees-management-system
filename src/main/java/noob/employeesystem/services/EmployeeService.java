package noob.employeesystem.services;

import noob.employeesystem.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void save(Employee employee);
    Employee getById(Long id);
    void deleteById(Long id);
}
