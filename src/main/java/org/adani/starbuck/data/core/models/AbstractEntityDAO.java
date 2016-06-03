package org.adani.starbuck.data.core.models;


/**
 * Defines an entity that can be queried for Data
 * The entity is defined by the type T.
 * @param <T>
 *           The type of the entity.
 */
public interface AbstractEntityDAO<T> {

    /**
     * Fetch an item using a filter.
     * @param filter
     *  Filter to restrict the result set.
     * @return
     *  The item resticted on filter.
     */
    T fetch(AbstractEntityFilter<T> filter);

    /**
     * Fetch a collection of items based on the filter.
     * The filter will also need to specify the result-sets starting location
     * and also the limit.
     * @param filter
     *  Filter to restrict the result set.
     * @return
     *  The item resticted on filter.
     */
    Page<T> fetchItems(AbstractEntityFilter<T> filter);


    /**
     * Create item. This will apply an insertion operation to the underlying data source.
     * This will result in the creation of a new record based on item T.
     * @param item
     *      The item to persist
     * @return
     *      The Persistent Item
     */
    T create(T item);

    /**
     * Update item. This will apply an uodate operation to the underlying data source on item.
     * This will result in the update of  item T.
     * @param item
     *      The item to update
     * @return
     *      The updated  Item
     */
    T update(T item);



    /**
     * Delete item. This will apply an delete operation to the underlying data source on item T.
     * This will result in the delete  of item T.
     * @param item
     *      The item to delete
     */
    void delete(T item);
}
