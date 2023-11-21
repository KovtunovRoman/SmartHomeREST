package ru.rvkovtunov.smart.server.domain.entity;

public abstract class AggregateRoot<ID> extends BaseEntity<ID>{

    protected AggregateRoot(final ID id){
        super(id);
    }

    protected AggregateRoot(){}
}
