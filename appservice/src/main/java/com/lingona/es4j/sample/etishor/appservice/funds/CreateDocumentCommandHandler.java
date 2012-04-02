package com.lingona.es4j.sample.etishor.appservice.funds;

//using Sample.Messages.Commands.Funds;

import com.lingona.es4j.domainpersistence.api.IRepository;
import com.lingona.es4j.sample.etishor.domainmodel.funds.AccessionNumber;
import com.lingona.es4j.sample.etishor.domainmodel.funds.Document;
import com.lingona.es4j.sample.etishor.messages.commands.funds.CreateDocument;
import java.util.UUID;

//using NanoMessageBus;
//using CommonDomain.Persistence;
//using Sample.DomainModel.Funds;


public class CreateDocumentCommandHandler implements IHandleMessages<CreateDocument> {
        private final IRepository repository;

        public CreateDocumentCommandHandler(IRepository repository)
        {
            this.repository = repository;
        }

        public void handle(CreateDocument message)
        {
            Console.WriteLine(message.getAccessionNumber());
            Document document = new Document(message.getId(), new AccessionNumber(message.AccessionNumber));
            repository.save(document, UUID.randomUUID(), null);
        }

}
