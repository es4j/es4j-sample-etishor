package com.lingona.es4j.sample.etishor.domainmodel.people;


/// Value object representing an address.
public class Address {

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }
    private final String street; // { get; private set; }
    private final String number; // { get; private set; }

    public String getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }
}
