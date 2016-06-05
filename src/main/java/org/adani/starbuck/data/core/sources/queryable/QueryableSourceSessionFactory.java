package org.adani.starbuck.data.core.sources.queryable;

import org.adani.starbuck.data.core.sources.db.DatabaseSessionFactory;
import org.adani.starbuck.data.core.sources.web.ServiceEndpointSessionFactory;

public class QueryableSourceSessionFactory {


    public static QueryableSession newSession(QueryableInitialisationConfiguration queryableInitialisationConfiguration) {

        QueryableSession queryableSession;

        switch (queryableInitialisationConfiguration.getQueryableType()) {

            case DATABASE:
                queryableSession = DatabaseSessionFactory.newInstance(queryableInitialisationConfiguration);
                return queryableSession;

            case SERVICE_END_POINT:
                queryableSession = ServiceEndpointSessionFactory.newInstance(queryableInitialisationConfiguration);
                return queryableSession;

            // Add additional cases and provide the instance creator for each

        }

        throw new RuntimeException("No suitable implementation found to initiate a session for " + queryableInitialisationConfiguration);

    }


}
