package org.adani.starbuck.data.core;

import org.adani.starbuck.data.core.models.Condition;

public interface Filter<T> {

    // Creation of Filter
    Filter<T> createFilterBasedOn(T item);


    // Manipulation of Filter
    Filter<T> addCondition(Condition condition);


    // Filter Meta-data
    String generateQuery();


    Class<T> getFilterType();

    String toString();
}
