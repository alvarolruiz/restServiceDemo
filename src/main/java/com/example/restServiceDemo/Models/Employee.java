package com.example.restServiceDemo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

//Los repositorios JPA son interfaces que contienen metodos para hacer CRUD en un soporte de almacenamiento de datos
// La anotación entity hace el modelo una entidad de persistencia lista para almacenarse en loa bdd jpa
@Entity
public class Employee {

    /**
     * La clase ha sido actualizada, de modo que los datos que estaban en la versión antigua se recuperan mediante
     * getters y setters virtuales.
     * Antes teníamos la propiedad name, mientras que ahora se encuentra dividida en dos (firstName y lastName).
     * De este modo cuando se produzca una actualización en el servidor los clientes que trabajen con la versión antigua
     * seguirán teniendo soporte. La idea es que nunca se pierda ninguna columna de una tabla o clase, pues eso
     * supondría una gran perdida económica.
     */
    //Con la anotacion @id se indica que será primary key cuando se introduza en la bdd de jpa. Será incrementado por jpa
    private @Id
    @GeneratedValue
    Long id;
    private String firstName;
    private String lastName;
    private String role;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    //Virual Method
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getRole() {
        return this.role;
    }

    //Virtual Method
    public void setName(String name) {
        String[] nameParts = name.split(" ");
        this.firstName = nameParts[0];
        this.lastName = nameParts[1];
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.firstName, employee.firstName)
                && Objects.equals(this.lastName, employee.lastName) && Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName
                + '\'' + ", role='" + this.role + '\'' + '}';
    }
}
