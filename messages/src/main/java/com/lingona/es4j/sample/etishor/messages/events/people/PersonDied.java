package com.lingona.es4j.sample.etishor.messages.events.people;

import com.lingona.es4j.sample.etishor.messages.IEvent;
import java.util.UUID;

public final class PersonDied implements IEvent {

    private final UUID id;

    public PersonDied(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
