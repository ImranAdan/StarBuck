package org.adani.starbuck.data.core.sources.db;

public interface Database {







    // Authentication



    // Session Meta-Data
    String getLoginUser();


    String getDatabaseName();


    // Operation



    interface ConfigurationMetaData{
        String URL_KEY = "conf_dburl";
        String USER_NAME="conf_user";
        String PASSWORD = "conf_password";
        String DRIVER_CLASS="conf_driver";
    }

    interface ActualMetaData{
        String URL_KEY = "actual_dburl";
        String USER_NAME="actual_user";
        String DRIVER_CLASS="actual_driver";
    }


}
