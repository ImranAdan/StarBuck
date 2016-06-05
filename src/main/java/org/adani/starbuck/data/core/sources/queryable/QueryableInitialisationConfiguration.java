package org.adani.starbuck.data.core.sources.queryable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;

public class QueryableInitialisationConfiguration {

    private static final String TYPE_KEY = "conf_type";
    private final String description;
    private Map<String, ?> configurations;

    public QueryableInitialisationConfiguration(String description, Map<String, Object> configurations) {
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
        QueryableSourceType type = QueryableSourceType.valueOf((String) configurations.get(TYPE_KEY));
        return type;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
