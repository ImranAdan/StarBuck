package org.adani.starbuck.data.jdbc.search;

import org.adani.starbuck.data.core.models.Condition;
import org.adani.starbuck.data.core.Filter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TypedJDBCSearchFilter<T> implements Filter<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypedJDBCSearchFilter.class);

    private final Class<T> parameterType;
    private final TypedJDBCSearchCondition<T> searchCondition;

    private final String query;
    private final int start;
    private final int limit;

    private TypedJDBCSearchFilter(Builder<T> builder){
        parameterType = builder.parameterType;
        searchCondition = builder.searchCondition;

        query = builder.query;
        start = builder.start;
        limit = builder.limit;
    }

    @Override
    public Filter<T> createFilterFrom(T item) {
        return null;
    }

    @Override
    public Filter<T> addCondition(Condition condition) {
        return null;
    }

    @Override
    public int start() {
        return getStart();
    }

    @Override
    public int limit() {
        return getLimit();
    }

    @Override
    public String generateQuery() {
        return this.query;
    }

    @Override
    public Class<T> getFilterType() {
        return getParameterType();
    }

    public String getQuery() {
        return query;
    }

    public int getStart() {
        return start;
    }

    public int getLimit() {
        return limit;
    }

    public Class<T> getParameterType() {
        return parameterType;
    }


    public static class Builder<T> {

        private static final Logger LOGGER = LoggerFactory.getLogger(TypedJDBCSearchFilter.class);
        private final Class<T> parameterType;
        private final TypedJDBCSearchCondition<T> searchCondition;

        private String query;
        private int start;
        private int limit;

        public Builder(Class<T> type) {
            this.parameterType = type;
            this.searchCondition = new TypedJDBCSearchCondition<>(type);

            // Default Values
            this.start = 0;
            this.limit = 25;
        }

        public Builder<T> start(int start){
            this.start = start;
            return this;
        }

        public Builder<T> limit(int limit){
            this.limit = limit;
            return this;
        }

        public Builder<T> addCondition(Condition filterCondition){
            searchCondition.add(filterCondition);
            return this;
        }

        public TypedJDBCSearchFilter<T> build(){
            LOGGER.info("Building TypedJDBCSearchFilter...");
            this.query = generateQuery();
            return new TypedJDBCSearchFilter<>(this);
        }

        String generateQuery(){
            String sql = searchCondition.convert();
            return sql;
        }

        @Override
        public String toString() {
            return  ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
        }
    }

    @Override
    public String toString() {
        return  ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

}
