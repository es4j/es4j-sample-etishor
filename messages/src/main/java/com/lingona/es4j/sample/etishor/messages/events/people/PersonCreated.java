package com.lingona.es4j.sample.etishor.messages.events.people;

import com.lingona.es4j.sample.etishor.messages.IEvent;
import java.util.UUID;


public final class PersonCreated implements IEvent {

    private final UUID   id;
    private final String name;
    private final String street;
    private final String streetNumber;

    public PersonCreated(UUID id, String name, String street, String streetNumber) {
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
