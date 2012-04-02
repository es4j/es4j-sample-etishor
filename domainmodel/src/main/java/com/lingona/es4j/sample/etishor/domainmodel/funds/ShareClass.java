package com.lingona.es4j.sample.etishor.domainmodel.funds;

import com.lingona.es4j.domain.api.IAggregate;
import com.lingona.es4j.domain.core.AggregateBase;
import com.lingona.es4j.sample.etishor.messages.IEvent;
import com.lingona.es4j.sample.etishor.messages.events.funds.ShareClassCreated;
import java.util.UUID;
//using Sample.Messages;
//using CommonDomain.Core;
//using Sample.Messages.Events.Funds;


public class ShareClass extends AggregateBase<IEvent> {

    private Ticker         ticker;
    private ShareClassType type;

    private ShareClass(UUID id) {
        this.id = id;
    }

    public ShareClass(UUID id, Ticker ticker, ShareClassType type) {
        this.id = id;
        raiseEvent(new ShareClassCreated(id, ticker.getSymbol(), type.getName().toString()));
    }

    private void apply(ShareClassCreated event) {
        this.ticker = new Ticker(event.getTicker());
        this.type = ShareClassType.createFromString(event.getType());
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
