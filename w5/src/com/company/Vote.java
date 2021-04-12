package com.company;

import java.util.Objects;
/**
 * a class for each vote
 * */
public class Vote {
    private Person person;
    private String date;

    public Vote(Person person, String date) {
        this.person = person;
        this.date = date;
    }

    /**
     * @return the person voted
     * */
    public Person getPerson() {return person;}

    /**
     * @return the date of vote
     * */
    public String getDate() {return date;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return person.equals(vote.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person);
    }
}