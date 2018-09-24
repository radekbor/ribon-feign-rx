package org.radekbor.gateway;

public class Book {

    private int id;

    private String name;

    private int customer;

    public Book(int id, String name, int customer) {
        this.id = id;
        this.name = name;
        this.customer = customer;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
