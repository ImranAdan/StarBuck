package org.adani.starbuck.data.jdbc.search;

import java.util.List;
import java.util.Map;

public class SearchCondition<T> {





    private final Class<?> parameterType;

    public SearchCondition(T item) {
        parameterType = item.getClass();
    }

    public List<String> getSearchConditionAttributes(){
        return null;
    }

    public Map<String, ?> getValues(){
        return null;
    }


    public Class<?> getParameterType() {
        return parameterType;
    }
}
