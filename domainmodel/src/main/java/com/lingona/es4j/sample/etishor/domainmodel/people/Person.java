package com.lingona.es4j.sample.etishor.domainmodel.people;

import java.util.UUID;

//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Text;
//using CommonDomain.Core;
//using Sample.Messages;
//using Sample.Messages.Events;
//using Sample.Messages.Events.People;


// Sample aggregate root in the domain.
public class Person extends AggregateBase<IEvent> {
        private PersonName name;
        private Address    currentAddress;
        private boolean    isAlive;

        /// <summary>
        /// Infrastructure constructor.
        /// </summary>
        private Person(UUID id) {
            if (UUIDExt.isEmpty(id))
            {
                throw new IllegalArgumentException("id");
            }

            this.id = id;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="Person"/> class.
        /// </summary>
        /// <param name="id">The id.</param>
        /// <param name="name">The name.</param>
        /// <param name="address">The address.</param>
        public Person(UUID id , PersonName name, Address address)
        {
            this.id = id;
            // the event will be routed by convention to a method called ApplyEvent(type of event)
            raiseEvent(new PersonCreated(id, name.Value,address.getStreet(), address.getNumber()));
        }

        /// <summary>
        /// Factory method for creating person objects.
        /// </summary>
        public static Person createPerson(UUID id, String name, String street, String streetNumber)
        {
            // in some cases the creation process is best delegated to a factory method.
            return new Person(id, new PersonName(name), new Address(street, streetNumber));
        }

        /// <summary>
        /// Moves this person to a new address.
        /// </summary>
        /// <param name="newAddress">The new address.</param>
        public void moveToAddress(Address newAddress)
        {
            // TODO: maybe publish an event signaling the error instead of throwing

            if (!this.isAlive)
            {
                throw new InvalidOperationException("Dead persons can't move.");
            }

            if (newAddress == currentAddress)
            {
                throw new InvalidOperationException("The new address must be different from the current one.");
            }

            RaiseEvent(new PersonMoved(Id, currentAddress.Street, currentAddress.Number, newAddress.Street, newAddress.Number));
        }

        /// <summary>
        /// Kills this person.
        /// </summary>
        public void kill()
        {
            if (!this.isAlive)
            {
                throw new InvalidOperationException("Dead persons can't die again.");
            }

            RaiseEvent(new PersonDied(Id));
        }

        // Applies the event. This method can be called when an aggregate method does RaiseEvent or
        // when the infrastructure loads the aggregate from the event stream.
        // <param name="event">The @event.</param>
        private void apply(PersonCreated event)
        {
            // in the apply event handlers we should only have property assignements
            this.name = new PersonName(@event.Name);
            this.currentAddress = new Address(@event.Street, @event.StreetNumber);
            this.isAlive = true;
        }

        private void apply(PersonMoved event)
        {
            this.currentAddress = new Address(@event.NewStreet, @event.NewNumber);
        }

        private void apply(PersonDied @event)
        {
            this.isAlive = false;
        }
    }
}
