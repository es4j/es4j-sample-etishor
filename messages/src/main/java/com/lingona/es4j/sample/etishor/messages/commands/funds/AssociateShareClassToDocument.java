package com.lingona.es4j.sample.etishor.messages.commands.funds;

import java.util.UUID;


public final class AssociateShareClassToDocument {

    private final UUID   documentId;
    private final UUID   shareClassId;
    private final String shareClassType;

    public AssociateShareClassToDocument(UUID documentId, UUID shareClassId, String shareClassType) {
        this.documentId = documentId;
        this.shareClassId = shareClassId;
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
