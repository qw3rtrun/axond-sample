package org.qw3rtrun.cqrs.axondsample.api.event;

public class ProductIntroduced {
    private final String name;

    public ProductIntroduced(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductIntroduced{" +
                "name='" + name + '\'' +
                '}';
    }
}
