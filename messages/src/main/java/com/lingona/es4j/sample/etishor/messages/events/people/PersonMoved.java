package com.lingona.es4j.sample.etishor.messages.events.people;

import com.lingona.es4j.sample.etishor.messages.IEvent;
import java.util.UUID;

public final class PersonMoved implements IEvent {

    private final UUID   id;
    private final String oldStreet;
    private final String oldNumber;
    private final String newStreet;
    private final String newNumber;

    public PersonMoved(UUID id, String oldStreet, String oldNumber, String newStreet, String newNumber) {
        this.id        = id;
        this.oldStreet = oldStreet;
        this.oldNumber = oldNumber;
        this.newStreet = newStreet;
        this.newNumber = newNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getNewNumber() {
        return newNumber;
    }

    public String getNewStreet() {
        return newStreet;
    }

    public String getOldNumber() {
        return oldNumber;
    }

    public String getOldStreet() {
        return oldStreet;
    }
}

