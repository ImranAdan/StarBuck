package org.adani.starbuck.data.core.sources.queryable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;

public class QueryableInitialisationConfig {

    private final String description;
    private Map<String, ?> configurations;

    public QueryableInitialisationConfig(String description, Map<String, Object> configurations){
        this.description = description;
        this.configurations = configurations;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, ?> getConfigurations() {
        return configurations;
    }

    public QueryableSourceType getQueryableType() {
        final QueryableSourceType type = (QueryableSourceType) configurations.get("type");
        return type;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
