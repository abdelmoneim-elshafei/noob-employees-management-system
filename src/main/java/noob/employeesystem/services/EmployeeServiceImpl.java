package noob.employeesystem.services;

import noob.employeesystem.model.Employee;
import noob.employeesystem.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        if(Objects.nonNull(employee)) {
            employeeRepository.save(employee);
        }
    }

    @Override
    public Employee getById(Long id) {
        Employee employee = null;
        if(Objects.nonNull(id)){
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            if(optionalEmployee.isPresent()){
                employee = optionalEmployee.get();
            }else{
                throw new RuntimeException("Employee Not Found");
            }
        }
        return employee;
        //return employeeRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        if(Objects.nonNull(id)) {
            employeeRepository.deleteById(id);
        }
    }
}
