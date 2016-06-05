package org.adani.starbuck.data.core.sources.queryable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class QueryableImpl implements Queryable {


    // Creation
    private final QueryableInitialisationConfiguration queryableInitialisationConfiguration;

    // Session
    private final QueryableSession queryableSession;


    public QueryableImpl(QueryableInitialisationConfiguration queryableInitialisationConfiguration) {
        this.queryableInitialisationConfiguration = queryableInitialisationConfiguration;
        queryableSession = QueryableSourceSessionFactory.newSession(queryableInitialisationConfiguration);
    }


    public QueryableInitialisationConfiguration getInitialisationConfiguration() {
        return queryableInitialisationConfiguration;
    }

    public QueryableSession createQueryableSourceSession() throws Exception {
        return getCreatedSession();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }


    private QueryableSession getCreatedSession(){
        return queryableSession;
    }

}
