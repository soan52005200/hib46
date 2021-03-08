package ru.sfedu.hibernate.Jr2.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class User implements Serializable {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NUMTEST", nullable = false)
    private int numtest;


    @Column(name = "PHONENUMBER", nullable = false)
    private String phoneNumber;


    public User() {
    }

    public User(String name, int numtest, String phoneNumber) {
        this.name = name;
        this.numtest = numtest;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumtest() {
        return numtest;
    }

    public void setNumtest(int numtest) {
        this.numtest = numtest;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", numtest=" + numtest +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}