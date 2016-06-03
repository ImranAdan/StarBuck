package org.adani.starbuck.data.core.filters;

import org.adani.starbuck.data.core.models.Condition;

/**
 * Defines a filter on a queryable entity. The filter must specify
 * creation, manipulation and the viewing of the state of the filter.
 * @param <T>
 *     Type of Entity
 */
public interface AbstractEntityFilter<T> {

    /********************************************************************
     *                  FILTER CREATION
     *******************************************************************/

    /**
     * Create a filter based on the properties of an attribute.
     * @param item
     *        A filter will be generated based on the properties of item T
     * @return
     *  AbstractEntityFilter the is restricted to the properties of item
     */
    AbstractEntityFilter<T> createBasedOn(T item);



    /********************************************************************
     *                  FILTER MANIPULATION
     *******************************************************************/

    /**
     * Add a condition to the filter. The set of
     * condition are to be used to generate the
     * underlying query for this filter.
     * @param condition
     *          Condition represents the boolean condition
     *          to be used to reduce a resultset from a queryable entity.
     *
     * @return
     *          A filter with the new condition applied.
     */
    AbstractEntityFilter<T> addCondition(Condition condition);


    /********************************************************************
     *                  FILTER META-DATA
     *******************************************************************/

    /**
     * The limit applied to the result set
     * obtained from the data source.
     * @return
     *  Total number of elements.
     */
    int limit();

    /**
     * Indicate a starting location for
     * a paginated result set.
     * @return
     */
    int start();

    /**
     * Generate a query for the underlying target
     * datasource.
     * @return
     *  The query will be used when intergating the data
     *  source for information.
     */
    String generateQuery();

    /**
     * The type of the filter. This mehtod must retain underlying type
     * during runtime.
     * @return
     *  Class represeting the filter type.
     *
     */
    Class<T> getFilterType();

    /**
     * Get the human readable string
     * that represents the current filter.
     * @return
     *  String for the current filter.
     */
    String toString();

}
