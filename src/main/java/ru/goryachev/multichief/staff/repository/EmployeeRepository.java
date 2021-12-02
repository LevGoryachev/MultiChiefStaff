package ru.goryachev.multichief.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.multichief.staff.model.Employee;

import java.util.List;

/**
 * EmployeeRepository (CRUD, find by person's initials methods).
 * @author Lev Goryachev
 * @version 1.1
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByFirstName(String firstName);
    List<Employee> findAllByMiddleName(String middleName);
    List<Employee> findAllByLastName(String lastName);
}
