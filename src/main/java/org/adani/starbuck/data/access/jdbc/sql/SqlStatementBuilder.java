package org.adani.starbuck.data.access.jdbc.sql;

import java.util.ArrayList;
import java.util.List;

public class SqlStatementBuilder {

    private final List<String> fields;
    private final List<String> operators;
    private final List<Object> values;


    public SqlStatementBuilder(SupportedSQLDialects supportedSQLDialects) {
        fields = new ArrayList<>();
        operators = new ArrayList<>();
        values = new ArrayList<>();
    }

    public List<String> getFields() {
        return fields;
    }

    public List<String> getOperators() {
        return operators;
    }

    public List<Object> getValues() {
        return values;
    }



}
