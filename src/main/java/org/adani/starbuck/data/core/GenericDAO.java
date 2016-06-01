package org.adani.starbuck.data.core;

import org.adani.starbuck.data.core.models.Page;

import java.util.Optional;

public interface GenericDAO<T> {

    T fetch(Filter<T> filter);

    Page<T> fetchItems(Filter<T> filter);

    T create(T item);

    T update(T item);

    void delete(T item);
}
