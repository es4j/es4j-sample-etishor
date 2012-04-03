package com.lingona.es4j.sample.etishor.appservice;

import com.lingona.es4j.domain.api.IAggregate;
import com.lingona.es4j.domain.api.IMemento;
import com.lingona.es4j.domainpersistence.api.IConstructAggregates;
import java.util.UUID;
//using CommonDomain.Persistence;
//using CommonDomain;
//using System.Reflection;


// Factory for creating aggregates from with their Id using a private constructor that accespts
// only one paramenter, the id of the aggregate to create.
// This factory is used by the event store to create an aggregate prior to replaying it's events.
public class AggregateFactory implements IConstructAggregates {

    @Override
    //public IAggregate build2(Class<IAggregate> type, UUID id, IMemento snapshot) {
    public <TAggregate extends IAggregate> TAggregate build(Class<TAggregate> type, UUID id, IMemento snapshot) {
        throw new UnsupportedOperationException("Not yet implemented");

        //ConstructorInfo constructor = type.GetConstructor(BindingFlags.NonPublic | BindingFlags.Instance, null, new Type[] { typeof(UUID) }, null);
        //return (TAggregate)constructor.invoke(new Object[] { id }) as IAggregate;

    }
}
