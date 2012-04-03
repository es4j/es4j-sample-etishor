package com.lingona.es4j.sample.etishor.appservice.people;

//using NanoMessageBus;
import com.lingona.es4j.domainpersistence.api.IRepository;
import com.lingona.es4j.sample.etishor.appservice.IHandleMessages;
import com.lingona.es4j.sample.etishor.domainmodel.people.Person;
import com.lingona.es4j.sample.etishor.messages.commands.people.CreatePerson;
import java.util.UUID;

//using Sample.Messages.Commands;
//using CommonDomain.Persistence;
//using Sample.DomainModel;
//using Sample.DomainModel.People;
//using Sample.Messages.Commands.People;
// Command handler for the CreatePerson command.
// Will construct a new Person Aggregate Root and store it in the repository.
public class CreatePersonCommandHandler implements IHandleMessages<CreatePerson> {

    private final IRepository repository;

    public CreatePersonCommandHandler(IRepository repository) {
        this.repository = repository;
    }

    public void handle(CreatePerson command) {
        // create a new instance of the person aggregate using the name and address from the command
        Person person = Person.createPerson(command.getId(),
                                            command.getName(),
                                            command.getStreet(),
                                            command.getStreetNumber());

        repository.save(person, UUID.randomUUID(), null);
    }
}
