package com.lingona.es4j.sample.etishor.messages.commands.people;

import java.io.Serializable;
import java.util.UUID;


public final class CreatePerson implements Serializable {

    private final UUID   id;
    private final String name;
    private final String street;
    private final String streetNumber;

    public CreatePerson(UUID id, String name, String street, String streetNumber) {
        this.id           = id;
        this.name         = name;
        this.street       = street;
        this.streetNumber = streetNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }
}
