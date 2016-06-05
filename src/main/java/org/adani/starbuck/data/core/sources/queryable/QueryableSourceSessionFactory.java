package org.adani.starbuck.data.core.sources.queryable;

import org.adani.starbuck.data.core.sources.db.DatabaseSourceSessionFactory;
import org.adani.starbuck.data.core.sources.web.ServiceEndpointSessionFactory;

public class QueryableSourceSessionFactory {


    public static QueryableSourceSession newSession(QueryableInitialisationConfig queryableInitialisationConfig) {

        QueryableSourceSession queryableSourceSession;

        switch (queryableInitialisationConfig.getQueryableType()) {

            case DATABASE:
                queryableSourceSession = DatabaseSourceSessionFactory.newInstance(queryableInitialisationConfig);
                return queryableSourceSession;

            case SERVICE_END_POINT:
                queryableSourceSession = ServiceEndpointSessionFactory.newInstance(queryableInitialisationConfig);
                return queryableSourceSession;


            default:
                throw new RuntimeException("No suitable implementation found to initiate a session for " + queryableInitialisationConfig);

        }


    }


}
