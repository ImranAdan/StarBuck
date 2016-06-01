package org.adani.starbuck.data.jdbc;

import org.adani.starbuck.data.core.models.Condition;
import org.adani.starbuck.data.jdbc.search.SearchCondition;
import org.adani.starbuck.data.core.Filter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TypedJDBCFilter<T> implements Filter<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypedJDBCFilter.class);
    private final Class<T> parameterType;


    // TODO: This need to be built using a builder pattern
    private final SearchCondition<T> searchCondition;


    public TypedJDBCFilter(Class<T> type){
        LOGGER.debug("Creating new empty TypedJDBCFilter<" + type.getCanonicalName()+">");
        parameterType = type;
        searchCondition = new SearchCondition<>(type);
    }

    public TypedJDBCFilter(SearchCondition<T> searchCondition) {
        parameterType = searchCondition.getParameterType();
        this.searchCondition = searchCondition;
    }

    public TypedJDBCFilter(T item) {
        this(baseOn(item));

    }

    private static <T> SearchCondition<T> baseOn(T item) {
        SearchCondition<T> basedOn = new SearchCondition<>(item);
        return basedOn;
    }


    @Override
    public Filter<T> createFilterBasedOn(T item) {
        //TODO: Create a filter based in the attributes of the object passed in
        return null;
    }

    @Override
    public Filter<T> addCondition(Condition condition) {
        //TODO: Add Conditions to the filter --> use a builder style pattern to build
        return null;
    }

    @Override
    public String generateQuery() {
        // Given the filter of this specific type generate a query appropriate for it
        return null;
    }

    @Override
    public Class<T> getFilterType() {
        return parameterType;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }























    public SearchCondition<T> getSearchCondition() {
        return searchCondition;
    }


    public Class<?> getParameterType() {
        return parameterType;
    }



}
