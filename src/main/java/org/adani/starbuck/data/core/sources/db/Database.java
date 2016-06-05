package org.adani.starbuck.data.core.sources.db;

public interface Database {







    // Authentication



    // Session Meta-Data
    String getLoginUser();


    String getDatabaseName();


    // Operation



    interface ConfigurationMetaData{
        String URL_KEY = "conf_dburl";
        String USER_NAME="conf_username";
        String PASSWORD = "conf_password";
        String DRIVER_CLASS="conf_driver";


        String TYPE_KEY = "conf_type";
    }

    interface ActualMetaData{
        String URL_KEY = "actual_dburl";
        String USER_NAME="actual_username";
        String DRIVER_CLASS="actual_driver";
    }


}
