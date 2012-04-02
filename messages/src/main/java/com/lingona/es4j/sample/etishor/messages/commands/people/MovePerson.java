package com.lingona.es4j.sample.etishor.messages.commands.people;

import java.io.Serializable;
import java.util.UUID;


public final class MovePerson implements Serializable {

    private final UUID personId;
    private final String street;
    private final String streetNumber;

    public MovePerson(UUID personId, String street, String streetNumber) {
        this.personId = personId;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public UUID getPersonId() {
        return personId;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }
}
