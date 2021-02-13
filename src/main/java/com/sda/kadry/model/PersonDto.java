package com.sda.kadry.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class PersonDto {

    @NotEmpty(message = "Jakieś imie musi być!")
    String firstName;
    @NotEmpty
    String lastName;
    @Min(2500)
    double salary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
