package org.adani.starbuck.data.core;

import org.adani.starbuck.data.core.models.Condition;

public interface Filter<T> {

    // Creation of Filter
    Filter<T> createFilterFrom(T item);

    // Manipulation of Filter
    Filter<T> addCondition(Condition condition);

    // Filter Meta-data
    int start();

    int limit();

    String generateQuery();

    Class<T> getFilterType();

    String toString();
}
