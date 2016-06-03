package org.adani.starbuck.data.core.models;


public interface AbstractEntityDAO<T> {

    T fetch(AbstractEntityFilter<T> filter);

    Page<T> fetchItems(AbstractEntityFilter<T> filter);

    T create(T item);

    T update(T item);

    void delete(T item);
}
