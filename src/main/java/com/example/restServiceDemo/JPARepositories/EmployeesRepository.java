package com.example.restServiceDemo.JPARepositories;

import com.example.restServiceDemo.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {
}
