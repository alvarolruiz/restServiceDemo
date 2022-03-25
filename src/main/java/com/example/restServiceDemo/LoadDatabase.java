package com.example.restServiceDemo;


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
    CommandLineRunner initDatabase(EmployeesRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo", "Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo",  "Baggins", "thief")));
        };
    }
}
