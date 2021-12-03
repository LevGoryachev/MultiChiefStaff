package ru.goryachev.multichief.staff.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.staff.model.Employee;
import ru.goryachev.multichief.staff.service.EmployeeService;

import java.util.List;

/**
 * MultiChiefStaff microservice API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees (@RequestParam (value = "lastname", required = false) String lastName) {
        return new ResponseEntity<>(employeeService.getAll(lastName), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getById (@PathVariable Long id) {
            return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.create(employee), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody Employee modifiedEmployee) {
        return new ResponseEntity<>(employeeService.update(modifiedEmployee), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.delete(id),HttpStatus.OK);
    }
}
