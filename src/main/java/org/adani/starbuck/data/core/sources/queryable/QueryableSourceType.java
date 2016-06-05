package org.adani.starbuck.data.core.sources.queryable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public enum QueryableSourceType {


    DATABASE("QueryableSourceType::DATABASE"),

    SERVICE_END_POINT("QueryableSourceType::SERVICE_ENDPOINT");


    private final String description;

    QueryableSourceType(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

}
