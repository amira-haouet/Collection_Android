package com.example.test;

public class Contact {
    //Attributes
    private String Name, Phone;

    //Constructor
    public Contact(String n, String p) {
        this.Name = n;
        this.Phone = p;
    }

    //Getters
    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }
}
