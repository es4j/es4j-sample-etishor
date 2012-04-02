package com.lingona.es4j.sample.etishor.appservice.funds;

//using Sample.Messages.Commands.Funds;
import com.lingona.es4j.domainpersistence.api.IRepository;
import com.lingona.es4j.sample.etishor.domainmodel.funds.ShareClass;
import com.lingona.es4j.sample.etishor.domainmodel.funds.ShareClassType;
import com.lingona.es4j.sample.etishor.domainmodel.funds.Ticker;
import com.lingona.es4j.sample.etishor.messages.commands.funds.CreateShareClass;
import java.util.UUID;

//using NanoMessageBus;
//using CommonDomain.Persistence;
//using Sample.DomainModel.Funds;
public class CreateShareClassCommandHandler implements IHandleMessages<CreateShareClass> {

    private final IRepository repository;

    public CreateShareClassCommandHandler(IRepository repository) {
        this.repository = repository;
    }

    public void handle(CreateShareClass message) {
        ShareClass share = new ShareClass(message.getId(),
                                          new Ticker(message.getTicker()),
                                                     ShareClassType.createFromString(message.getType()));
        repository.save(share, UUID.randomUUID(), null);
    }
}
