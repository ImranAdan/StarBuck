package org.adani.starbuck.data.jdbc.search;

import org.adani.starbuck.data.core.models.Condition;

import java.util.List;
import java.util.Map;

public class SearchCondition<T> {

    private final Class<?> parameterType;
    private final List<Condition> conditions;


    public SearchCondition(T item) {
        parameterType = item.getClass();
        conditions = generateConditionsFrom(item);
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



    private List<Condition> generateConditionsFrom(T item) {

        if(item != null) {



        }

        throw new RuntimeException("Can not generate Conditions from Item: " + item.toString());
    }

}
