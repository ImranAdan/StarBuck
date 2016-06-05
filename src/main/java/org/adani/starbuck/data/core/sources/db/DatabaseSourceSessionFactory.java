package org.adani.starbuck.data.core.sources.db;

import org.adani.starbuck.data.core.sources.queryable.QueryableInitialisationConfiguration;
import org.adani.starbuck.data.core.sources.queryable.QueryableSourceSession;

public final class DatabaseSourceSessionFactory {

    public static QueryableSourceSession newInstance(QueryableInitialisationConfiguration queryableConfigurations) {

        String url = (String) queryableConfigurations.getConfigurations().get(Database.ConfigurationMetaData.URL_KEY);
        String userName = (String) queryableConfigurations.getConfigurations().get(Database.ConfigurationMetaData.USER_NAME);
        String pass = (String) queryableConfigurations.getConfigurations().get(Database.ConfigurationMetaData.PASSWORD);
        String driverClass = (String) queryableConfigurations.getConfigurations().get(Database.ConfigurationMetaData.DRIVER_CLASS);

        return new DatabaseSourceSession(queryableConfigurations, url, userName, pass, driverClass);

    }

}
