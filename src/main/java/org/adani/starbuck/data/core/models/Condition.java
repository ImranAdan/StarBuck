package org.adani.starbuck.data.core.models;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Condition")
public class Condition {

    private final String field;
    private final Operator operator;
    private final Object value;



    public Condition(String field, Operator operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public Operator getOperator() {
        return operator;
    }

    public Object getValue() {
        return value;
    }
}
