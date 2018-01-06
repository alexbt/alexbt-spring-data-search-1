package com.alexbt.jpa.search.criteria.abst;

import javax.validation.constraints.NotNull;

public abstract class BasicSearchCriteria<T> extends SearchCriteria<T> {
    @NotNull
    private T value;

    protected T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
