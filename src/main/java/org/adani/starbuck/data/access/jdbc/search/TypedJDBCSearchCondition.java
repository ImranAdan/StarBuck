package org.adani.starbuck.data.access.jdbc.search;

import org.adani.starbuck.data.core.models.Condition;

import java.util.ArrayList;
import java.util.List;

public class TypedJDBCSearchCondition<T> {

    private final Class<T> parameterType;
    private final List<Condition> conditions;


    public TypedJDBCSearchCondition(Class<T> parameterType) {
        this.parameterType = parameterType;
        conditions = new ArrayList<>();
    }

    public void add(Condition filterCondition) {
        this.conditions.add(filterCondition);
    }

    public Class<T> getParameterType() {
        return parameterType;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public String convert() {

        StringBuilder sb = new StringBuilder("SELECT ");
        for (Condition c: conditions ) {
            sb.append(c.getField() + ", ");
        }

        sb = sb.replace(sb.toString().length() -1, sb.length(), "");
        sb.append("FROM ");
        sb.append(parameterType.getSimpleName());
        sb.append(" WHERE ");


        return sb.toString();
    }
}
