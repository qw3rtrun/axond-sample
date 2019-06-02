package org.qw3rtrun.cqrs.axondsample;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.qw3rtrun.cqrs.axondsample.api.cmd.IntroduceProduct;
import org.qw3rtrun.cqrs.axondsample.api.event.ProductIntroduced;

@Aggregate
public class Product {

    @AggregateIdentifier
    private String name;

    public Product() {
    }

    @CommandHandler
    public Product(IntroduceProduct cmd) {
        AggregateLifecycle.apply(new ProductIntroduced(cmd.getName()));
    }

    @EventSourcingHandler
    public void on(ProductIntroduced e) {
        this.name = e.getName();
    }
}
