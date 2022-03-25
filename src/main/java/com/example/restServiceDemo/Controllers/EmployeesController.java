package com.example.restServiceDemo.Controllers;

import com.example.restServiceDemo.JPARepositories.EmployeesRepository;
import com.example.restServiceDemo.Models.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeesController {

    private final EmployeesRepository repository;


    public EmployeesController(EmployeesRepository repository) {
        this.repository = repository;
    }

    //Agregate root
    //tag::get-aggregate-root[]
    @GetMapping("/employees")
    List<Employee> all(){
        return repository.findAll();
    }

    @PostMapping ("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }

    //Single item get

    @GetMapping("/employees/{id}")
    Employee one (@PathVariable Long id){
        return repository.findById(id).orElseThrow(()-> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
