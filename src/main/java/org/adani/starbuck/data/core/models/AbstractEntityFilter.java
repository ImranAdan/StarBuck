package org.adani.starbuck.data.core.models;

/**
 * Defines a filter on a queryable entity. The filter must specify
 * creation, manipulation and the viewing of the state of the filter.
 * @param <T>
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

    int limit();

    int start();

    String generateQuery();

    Class<T> getFilterType();

    String toString();

}
