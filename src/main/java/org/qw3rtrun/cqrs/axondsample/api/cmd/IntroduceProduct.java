package org.qw3rtrun.cqrs.axondsample.api.cmd;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class IntroduceProduct {

    @TargetAggregateIdentifier
    private final String name;

    public IntroduceProduct(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
