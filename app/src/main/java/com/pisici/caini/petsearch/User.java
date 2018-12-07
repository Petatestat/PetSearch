package com.pisici.caini.petsearch;

import java.io.Serializable;

public class User implements Serializable {
    private String First_name = "nu a mers:(";
    private String Last_name = "null";
    private String Email= "null";
    private String Phone= "07noidoi";
    private int Number_of_pets=0;
    private Pet[] pets;

    public User(String first_name,String last_name,String email, String phone) {
        First_name = first_name;
        Last_name=last_name;
        Email=email;
        Phone=phone;
    }
    public User(){}

    public String getFirst_name() {
        return First_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getNumber_of_pets() {
        return Number_of_pets;
    }

    public void setNumber_of_pets(int number_of_pets) {
        Number_of_pets = number_of_pets;
    }
}
