package com.lingona.es4j.sample.etishor.domainmodel.funds;

import com.lingona.es4j.domain.api.IAggregate;
import com.lingona.es4j.domain.core.AggregateBase;
import com.lingona.es4j.sample.etishor.messages.IEvent;
import com.lingona.es4j.sample.etishor.messages.events.funds.DocumentAssociatedWithShareclass;
import com.lingona.es4j.sample.etishor.messages.events.funds.DocumentCreated;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
//using Sample.Messages;
//using CommonDomain.Core;
//using Sample.Messages.Events.Funds;


public class Document extends AggregateBase<IEvent> {

    private AccessionNumber accessionNumber;
    private List<DocumentShareClassAssociation> shareClassAssociations = new LinkedList<DocumentShareClassAssociation>();

    private Document(UUID id) {
        this.id = id;
    }

    public Document(UUID id, AccessionNumber accessionNumber) {
        this.id = id;
        raiseEvent(new DocumentCreated(id, accessionNumber.getValue()));
    }

    public void associateWithShareClass(DocumentShareClassAssociation association) {
        if (!association.getShareType().isLinkable()) {
            throw new IllegalStateException("Only linkable share classes can be associated with documents");
        }

        raiseEvent(new DocumentAssociatedWithShareclass(this.id, association.getShareClassId(), association.getShareType().getName().toString()));
    }

    private void apply(DocumentCreated event) {
        this.accessionNumber = new AccessionNumber(event.getAccessionNumber());
    }

    private void apply(DocumentAssociatedWithShareclass event) {
        DocumentShareClassAssociation dsca = new DocumentShareClassAssociation(event.getDocumentId(),
                                          event.getShareClassId(),
                                          ShareClassType.createFromString(event.getShareClassType()));
        this.shareClassAssociations.add(dsca);
    }

    @Override
    public void throwHandlerNotFound(Object eventMessage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean equalsTo(IAggregate other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
