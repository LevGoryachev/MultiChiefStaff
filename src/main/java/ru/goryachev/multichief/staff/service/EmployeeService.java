package ru.goryachev.multichief.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.staff.model.Employee;
import ru.goryachev.multichief.staff.repository.EmployeeRepository;

import java.util.List;

/**
 * EmployeeService works with types: Employee, EmployeeDTO.
 * @author Lev Goryachev
 * @version 3
 */

@Service
public class EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll(String lastName) throws EmptyListException {
        if (lastName == null) {
            List<Employee> allEmployees = employeeRepository.findAll();
            if (allEmployees.isEmpty()) {
                throw new EmptyListException();
            }
            return allEmployees;
        }
        List<Employee> allEmployees = employeeRepository.findAllByLastName(lastName);
        if (allEmployees.isEmpty()) {
            throw new EmptyListException();
        }
        return allEmployees;
    }

    public Employee getById(Long id) throws EntityNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
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
