package com.example.restServiceDemo;


import com.example.restServiceDemo.JPARepositories.OrdersRepository;
import com.example.restServiceDemo.Models.Order;
import com.example.restServiceDemo.Models.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.restServiceDemo.JPARepositories.EmployeesRepository;
import com.example.restServiceDemo.Models.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Al ser marcada la calse como Configuration se ejecutará en primer lugar una vez se inicie la app
@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // La aplicacion carga todos los command line runner beans cuando el contexto de la app es cargado
    // El rummer hará una copia del repositoiro de empleados creado anteriormente. Creará dos entidades y las guarará
    // Creamos un Bean que será cargado en primer lugar cuando se ejecute la aplicacion
    @Bean
    CommandLineRunner initDatabase(EmployeesRepository employeesRepository, OrdersRepository ordersRepository) {
        return args -> {
            employeesRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
            employeesRepository.save(new Employee("Frodo", "Baggins", "thief"));
            employeesRepository.findAll().forEach(employee ->
                log.info(String.format("Preloaded %s.", employee)));

            ordersRepository.save(new Order("Macbook", Status.IN_PROGRESS));
            ordersRepository.save(new Order("iPhone", Status.COMPLETED));
            ordersRepository.findAll().forEach(order ->
                log.info(String.format("Preloaded %s.",order)));

        };
    }
}
