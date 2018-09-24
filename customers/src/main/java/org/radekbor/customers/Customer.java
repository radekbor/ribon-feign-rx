package org.radekbor.customers;

public class Customer {

    private long id;

    private String firstName;

    private String secondName;

    public Customer(long id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public long getId() {
        return id;
    }
}
