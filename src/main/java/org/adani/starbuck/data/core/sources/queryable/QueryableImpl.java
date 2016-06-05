package org.adani.starbuck.data.core.sources.queryable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class QueryableImpl implements Queryable {


    // Creation
    private final QueryableInitialisationConfiguration queryableInitialisationConfiguration;

    // Session
    private final QueryableSourceSession queryableSourceSession;


    public QueryableImpl(QueryableInitialisationConfiguration queryableInitialisationConfiguration) {
        this.queryableInitialisationConfiguration = queryableInitialisationConfiguration;
        queryableSourceSession = QueryableSourceSessionFactory.newSession(queryableInitialisationConfiguration);
    }


    public QueryableInitialisationConfiguration getQueryableInitialisationConfiguration() {
        return queryableInitialisationConfiguration;
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
