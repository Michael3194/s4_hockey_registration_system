package com.keyin.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.util.Calendar;

@Entity
public class Player {

    @Id
    @SequenceGenerator(name = "player_sequence", sequenceName = "player_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "player_sequence")
    private long id;
    private Calendar birthday;
    private String firstName;
    private String lastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

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
}
