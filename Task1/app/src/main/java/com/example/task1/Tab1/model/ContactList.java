package com.example.task1.Tab1.model;

public class ContactList {

    private String  url;
    private String name;
    private String phone_number;
    private String address;

    public ContactList(String url, String name, String phone_number, String address) {

        this.url = url;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;

    }

    public String getUrl() {
        return url;
    }

    public String getName() { return name; }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }
}
