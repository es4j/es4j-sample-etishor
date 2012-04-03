package com.lingona.es4j.sample.etishor.appservice.people;

//using Sample.Messages.Commands;
import com.lingona.es4j.domainpersistence.api.IRepository;
import com.lingona.es4j.sample.etishor.appservice.IHandleMessages;
import com.lingona.es4j.sample.etishor.domainmodel.people.Person;
import com.lingona.es4j.sample.etishor.messages.commands.people.KillPerson;
import java.util.UUID;

//using NanoMessageBus;
//using CommonDomain.Persistence;
//using Sample.DomainModel;
//using Sample.DomainModel.People;
//using Sample.Messages.Commands.People;
public class KillPersonCommandHandler implements IHandleMessages<KillPerson> {

    private final IRepository repository;

    public KillPersonCommandHandler(IRepository repository) {
        this.repository = repository;
    }

    public void handle(KillPerson command) {
        Person person = repository.getById(Person.class, command.getVictimId(), Integer.MAX_VALUE);

        person.kill();

        repository.save(person, UUID.randomUUID(), null);
    }
}
