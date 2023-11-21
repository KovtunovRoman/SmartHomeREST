package ru.rvkovtunov.smart.server.domain.entity;

import java.util.Objects;

public abstract class BaseEntity<ID> {

    private ID id;

    protected BaseEntity(final ID id){
        this.id = id;
    }

    protected BaseEntity(){}

    public ID getId() {
        return this.id;
    }

    public void setId(final ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
