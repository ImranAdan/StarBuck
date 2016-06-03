package org.adani.starbuck.data.core.models;

import java.util.Arrays;
import java.util.List;

public enum Operator {

    EQUALS(Arrays.asList("=")),
    NOT_EQUALS(Arrays.asList("!=", "^=", "<>")),
    GREATER_THAN(Arrays.asList(">")),
    LESS_THAN(Arrays.asList("<")),
    GREATER_THAN_OR_EQUALS_TO(Arrays.asList(">=")),
    LESS_THAN_OR_EQUALS_TO(Arrays.asList("<="));

    private final List<String> operatorSymbols;

    Operator(List<String> operatorSymbols){
        this.operatorSymbols = operatorSymbols;
    }

    /**
     * Get the set of symbols representing this
     * operator.
     * @return
     *  The set of symbols representing the operator
     */
    public List<String> getOperatorSymbols() {
        return operatorSymbols;
    }
}
