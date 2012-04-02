package com.lingona.es4j.sample.etishor.messages.commands.people;

import java.io.Serializable;
import java.util.UUID;

public final class KillPerson {

    private final UUID victimId;

    public KillPerson(UUID victimId) {
        this.victimId = victimId;
    }

    public UUID getVictimId() {
        return victimId;
    }
}
