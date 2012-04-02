package com.lingona.es4j.sample.etishor.messages.events.funds;

import com.lingona.es4j.sample.etishor.messages.IEvent;
import java.util.UUID;


public final class ShareClassCreated implements IEvent {

    private final UUID id;
    private final String ticker;
    private final String type;

    public ShareClassCreated(UUID id, String ticker, String type) {
        this.id = id;
        this.ticker = ticker;
        this.type = type;
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

