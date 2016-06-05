package org.adani.starbuck.data.core.sources.queryable;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class QueryableSourceSession {

    private final QueryableInitialisationConfiguration queryableInitialisationConfiguration;
    private final Map<String, Object> sessionMeta;

    protected QueryableSourceSession(QueryableInitialisationConfiguration queryableInitialisationConfiguration) {
        this.queryableInitialisationConfiguration = queryableInitialisationConfiguration;
        sessionMeta = new HashMap<>();
    }

    public QueryableInitialisationConfiguration getQueryableInitialisationConfiguration() {
        return queryableInitialisationConfiguration;
    }

    public Map<String, Object> getSessionMeta() {
        return sessionMeta;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
