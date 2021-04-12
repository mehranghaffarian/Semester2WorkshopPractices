package com.company;

import java.util.Objects;
/**
 * a class for the info of each person who has voted
 * */
public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * @return the firstName of the person
     * */
    public String getFirstName() {return firstName;}
    /**
     * @return the last name of the person
     * */
    public String getLastName() {return lastName;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {return Objects.hash(firstName, lastName);}
    /**
     * @return the whole name of the person
     * */
    public String toString(){return firstName.concat(" ").concat(lastName);}
}