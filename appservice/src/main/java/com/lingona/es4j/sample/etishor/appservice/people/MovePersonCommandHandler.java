package com.lingona.es4j.sample.etishor.appservice.people;

import com.lingona.es4j.domainpersistence.api.IRepository;
import com.lingona.es4j.sample.etishor.domainmodel.people.Address;
import com.lingona.es4j.sample.etishor.domainmodel.people.Person;
import com.lingona.es4j.sample.etishor.messages.commands.people.MovePerson;
import java.util.UUID;

//using Sample.Messages.Commands;
//using NanoMessageBus;
//using CommonDomain.Persistence;
//using Sample.DomainModel;
//using Sample.DomainModel.People;
//using Sample.Messages.Commands.People;
/// Command handler for the MovePerson command.
/// Finds the person aggregate by the Id and calls MoveToAddress() on it then saves
/// the AR in the repository.
public class MovePersonCommandHandler implements IHandleMessages<MovePerson> {

    private final IRepository repository;

    public MovePersonCommandHandler(IRepository repository) {
        this.repository = repository;
    }

    public void handle(MovePerson command) {
        // Command Handlers should usualy keep it simple Get AR, Call Method on AR, Save AR

        // get by id
        Person person = repository.getById(Person.class, command.getPersonId(), Integer.MAX_VALUE);

        // call method
        person.moveToAddress(new Address(command.getStreet(), command.getStreetNumber()));

        // save
        repository.save(person, UUID.randomUUID(), null);
    }
}
}
