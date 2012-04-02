package com.lingona.es4j.sample.etishor.domainmodel.funds;

import java.util.UUID;

public class DocumentShareClassAssociation {

    private final UUID           documentId;   // { get; private set; }
    private final UUID           shareClassId; // { get; private set; }
    private final ShareClassType shareType;    // { get; private set; }

    public DocumentShareClassAssociation(UUID documentId, UUID shareClassId, ShareClassType shareClassType) {
        this.documentId = documentId;
        this.shareClassId = shareClassId;
        this.shareType = shareClassType;
    }

    public UUID getDocumentId() {
        return documentId;
    }

    public UUID getShareClassId() {
        return shareClassId;
    }

    public ShareClassType getShareType() {
        return shareType;
    }
}
