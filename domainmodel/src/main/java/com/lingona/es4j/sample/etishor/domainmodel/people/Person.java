package com.lingona.es4j.sample.etishor.domainmodel.people;

import com.lingona.es4j.domain.api.IAggregate;
import com.lingona.es4j.domain.core.AggregateBase;
import com.lingona.es4j.sample.etishor.messages.IEvent;
import com.lingona.es4j.sample.etishor.messages.events.people.PersonCreated;
import com.lingona.es4j.sample.etishor.messages.events.people.PersonDied;
import com.lingona.es4j.sample.etishor.messages.events.people.PersonMoved;
import java.util.UUID;
//using CommonDomain.Core;
//using Sample.Messages;
//using Sample.Messages.Events;
//using Sample.Messages.Events.People;


// Sample aggregate root in the domain.
public class Person extends AggregateBase<IEvent> {

    private PersonName name;
    private Address currentAddress;
    private boolean isAlive;

    // Infrastructure constructor.
    private Person(UUID id) {
        if (UUIDExt.isEmpty(id)) {
            throw new IllegalArgumentException("id");
        }

        this.id = id;
    }

    // Initializes a new instance of the <see cref="Person"/> class.
    // <param name="id">The id.</param>
    // <param name="name">The name.</param>
    // <param name="address">The address.</param>
    public Person(UUID id, PersonName name, Address address) {
        this.id = id;
        // the event will be routed by convention to a method called ApplyEvent(type of event)
        raiseEvent(new PersonCreated(id, name.getValue(), address.getStreet(), address.getNumber()));
    }

    // Factory method for creating person objects.
    public static Person createPerson(UUID id, String name, String street, String streetNumber) {
        // in some cases the creation process is best delegated to a factory method.
        return new Person(id, new PersonName(name), new Address(street, streetNumber));
    }

    // Moves this person to a new address.
    // <param name="newAddress">The new address.</param>
    public void moveToAddress(Address newAddress) {
        // TODO: maybe publish an event signaling the error instead of throwing

        if (!this.isAlive) {
            throw new IllegalStateException("Dead persons can't move.");
        }

        if (newAddress == currentAddress) {
            throw new IllegalStateException("The new address must be different from the current one.");
        }

        raiseEvent(new PersonMoved(id,
                                   currentAddress.getStreet(),
                                   currentAddress.getNumber(),
                                   newAddress.getStreet(),
                                   newAddress.getNumber()));
    }

    /// Kills this person.
    public void kill() {
        if (!this.isAlive) {
            throw new IllegalStateException("Dead persons can't die again.");
        }

        raiseEvent(new PersonDied(id));
    }

    // Applies the event. This method can be called when an aggregate method does RaiseEvent or
    // when the infrastructure loads the aggregate from the event stream.
    // <param name="event">The @event.</param>
    private void apply(PersonCreated event) {
        // in the apply event handlers we should only have property assignements
        this.name = new PersonName(event.getName());
        this.currentAddress = new Address(event.getStreet(), event.getStreetNumber());
        this.isAlive = true;
    }

    private void apply(PersonMoved event) {
        this.currentAddress = new Address(event.getNewStreet(), event.getNewNumber());
    }

    private void apply(PersonDied event) {
        this.isAlive = false;
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
