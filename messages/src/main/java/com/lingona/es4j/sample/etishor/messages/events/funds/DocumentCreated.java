package com.lingona.es4j.sample.etishor.messages.events.funds;

import com.lingona.es4j.sample.etishor.messages.IEvent;
import java.util.UUID;


public final class DocumentCreated implements IEvent {

    private final UUID   id;
    private final String accessionNumber;

    public DocumentCreated(UUID id, String accessionNumber) {
        this.id              = id;
        this.accessionNumber = accessionNumber;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public UUID getId() {
        return id;
    }
}
