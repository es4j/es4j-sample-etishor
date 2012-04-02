package com.lingona.es4j.sample.etishor.messages.commands.funds;

import java.io.Serializable;
import java.util.UUID;

public final class CreateShareClass implements Serializable {

    private final UUID   id;
    private final String ticker;
    private final String type;

    public CreateShareClass(UUID id, String ticker, String type) {
        this.id     = id;
        this.ticker = ticker;
        this.type   = type;
    }

    public UUID getId() {
        return id;
    }

    public String getTicker() {
        return ticker;
    }

    public String getType() {
        return type;
    }
}
