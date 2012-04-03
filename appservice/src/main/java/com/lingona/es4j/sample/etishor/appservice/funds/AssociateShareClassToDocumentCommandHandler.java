package com.lingona.es4j.sample.etishor.appservice.funds;

import com.lingona.es4j.domainpersistence.api.IRepository;
import com.lingona.es4j.sample.etishor.appservice.IHandleMessages;
import com.lingona.es4j.sample.etishor.domainmodel.funds.Document;
import com.lingona.es4j.sample.etishor.domainmodel.funds.DocumentShareClassAssociation;
import com.lingona.es4j.sample.etishor.domainmodel.funds.ShareClassType;
import com.lingona.es4j.sample.etishor.messages.commands.funds.AssociateShareClassToDocument;
import java.util.UUID;

//using Sample.Messages.Commands.Funds;
//using NanoMessageBus;
//using CommonDomain.Persistence;
//using Sample.DomainModel.Funds;


public class AssociateShareClassToDocumentCommandHandler implements IHandleMessages<AssociateShareClassToDocument> {
    private final IRepository repository;

    public AssociateShareClassToDocumentCommandHandler(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(AssociateShareClassToDocument message) {

        Document document = repository.getById(Document.class, message.getDocumentId(), Integer.MAX_VALUE);

        DocumentShareClassAssociation association =
                new DocumentShareClassAssociation(document.getId(),
                                                  message.getShareClassId(),
                                                  ShareClassType.createFromString(message.getShareClassType()));

        document.associateWithShareClass(association);

        repository.save(document, UUID.randomUUID(), null);
    }
}
