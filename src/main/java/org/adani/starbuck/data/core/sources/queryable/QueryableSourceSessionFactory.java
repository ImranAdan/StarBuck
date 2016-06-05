package org.adani.starbuck.data.core.sources.queryable;

import org.adani.starbuck.data.core.sources.db.DatabaseSourceSessionFactory;
import org.adani.starbuck.data.core.sources.web.ServiceEndpointSessionFactory;

public class QueryableSourceSessionFactory {


    public static QueryableSourceSession newSession(QueryableInitialisationConfiguration queryableInitialisationConfiguration) {

        QueryableSourceSession queryableSourceSession;

        switch (queryableInitialisationConfiguration.getQueryableType()) {

            case DATABASE:
                queryableSourceSession = DatabaseSourceSessionFactory.newInstance(queryableInitialisationConfiguration);
                return queryableSourceSession;

            case SERVICE_END_POINT:
                queryableSourceSession = ServiceEndpointSessionFactory.newInstance(queryableInitialisationConfiguration);
                return queryableSourceSession;

            // Add additional cases and provide the instance creator for each

        }

        throw new RuntimeException("No suitable implementation found to initiate a session for " + queryableInitialisationConfiguration);

    }


}
