package org.adani.starbuck.data.jdbc;

import org.adani.starbuck.data.core.models.Condition;
import org.adani.starbuck.data.jdbc.search.SearchCondition;
import org.adani.starbuck.data.core.Filter;
import org.adani.starbuck.domain.product.Product;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TypedJDBCFilter<T> implements Filter<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypedJDBCFilter.class);

    private final Class<T> parameterType;
    private final SearchCondition<T> searchCondition;

    private final String query;
    private final int start;
    private final int limit;

    private TypedJDBCFilter(Builder<T> builder){
        parameterType = builder.parameterType;
        searchCondition = builder.searchCondition;

        query = builder.query;
        start = builder.start;
        limit = builder.limit;
    }

    @Override
    public Filter<T> basedOn(T item) {
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
        /**
         *
         * TODO: Generate the SQL String here
         *
         */
        return null;
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


    public static class Builder<T>{

        private final Class<T> parameterType;
        private final SearchCondition<T> searchCondition;

        private  String query;
        private  int start;
        private  int limit;

        public Builder(Class<T> parameterType, SearchCondition<T> searchCondition) {
            this.parameterType = parameterType;
            this.searchCondition = searchCondition;
        }




        public Builder<T> start(int start){
            this.start = start;
            return this;
        }

        public Builder<T> limit(int limit){
            this.limit = limit;
            return this;
        }

        public TypedJDBCFilter<T> build(){
            return new TypedJDBCFilter<>(this);
        }

        @Override
        public String toString() {
            return  ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
        }
    }

}
