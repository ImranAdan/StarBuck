package org.adani.starbuck.data.core.sources.queryable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class QueryableImpl implements Queryable {


    // Creation
    private final QueryableInitialisationConfig queryableInitialisationConfig;

    // Session
    private final QueryableSourceSession queryableSourceSession;


    public QueryableImpl(QueryableInitialisationConfig queryableInitialisationConfig) {
        this.queryableInitialisationConfig = queryableInitialisationConfig;
        queryableSourceSession = QueryableSourceSessionFactory.newSession(queryableInitialisationConfig);
    }


    public QueryableInitialisationConfig getQueryableInitialisationConfig() {
        return queryableInitialisationConfig;
    }

    public QueryableSourceSession getQueryableSourceSession() throws Exception {
        return getCreatedSession();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }


    private QueryableSourceSession getCreatedSession(){
        return queryableSourceSession;
    }

}
