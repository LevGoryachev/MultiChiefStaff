package ru.goryachev.multichief.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.staff.exception.MultiChiefEmptyListException;
import ru.goryachev.multichief.staff.exception.MultiChiefObjectNotFoundException;
import ru.goryachev.multichief.staff.model.Employee;
import ru.goryachev.multichief.staff.repository.EmployeeRepository;

import java.util.List;

/**
 * EmployeeService works with types: Employee, EmployeeDTO.
 * @author Lev Goryachev
 * @version 3
 */

@Service
@PropertySource("classpath:service_layer.properties")
public class EmployeeService {

    @Value("${model.entity.alias.employee}")
    private String employeeEntityAlias;

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll(String lastName) throws MultiChiefEmptyListException {
        if (lastName == null) {
            List<Employee> allEmployees = employeeRepository.findAll();
            if (allEmployees.isEmpty()) {
                throw new MultiChiefEmptyListException(employeeEntityAlias);
            }
            return allEmployees;
        }
        List<Employee> allEmployees = employeeRepository.findAllByLastName(lastName);
        if (allEmployees.isEmpty()) {
            throw new MultiChiefEmptyListException(employeeEntityAlias);
        }
        return allEmployees;
    }

    public Employee getById(Long id) throws MultiChiefObjectNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new MultiChiefObjectNotFoundException(employeeEntityAlias, id));
        return employee;
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Employee modifiedEmployee) {
        return employeeRepository.save(modifiedEmployee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
