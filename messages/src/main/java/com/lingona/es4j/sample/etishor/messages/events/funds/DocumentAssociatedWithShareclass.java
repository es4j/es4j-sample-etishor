package com.lingona.es4j.sample.etishor.messages.events.funds;

import com.lingona.es4j.sample.etishor.messages.IEvent;
import java.util.UUID;


public final class DocumentAssociatedWithShareclass implements IEvent {

    private final UUID   documentId;
    private final UUID   shareClassId;
    private final String shareClassType;

    public DocumentAssociatedWithShareclass(UUID documentId, UUID shareClassId, String shareClassType) {
        this.documentId     = documentId;
        this.shareClassId   = shareClassId;
        this.shareClassType = shareClassType;
    }

    public UUID getDocumentId() {
        return documentId;
    }

    public UUID getShareClassId() {
        return shareClassId;
    }

    public String getShareClassType() {
        return shareClassType;
    }
}
