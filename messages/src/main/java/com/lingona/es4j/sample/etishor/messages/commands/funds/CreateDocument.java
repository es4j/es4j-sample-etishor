package com.lingona.es4j.sample.etishor.messages.commands.funds;

import java.util.UUID;

public final class CreateDocument {

    private final UUID id;
    private final String accessionNumber;

    public CreateDocument(UUID id, String accessionNumber) {
        this.id = id;
        this.accessionNumber = accessionNumber;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public UUID getId() {
        return id;
    }
}
