package org.adani.starbuck.data.core.sources.db;

import org.adani.starbuck.data.core.sources.queryable.QueryableInitialisationConfig;
import org.adani.starbuck.data.core.sources.queryable.QueryableSourceSession;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class DatabaseSourceSession extends QueryableSourceSession {

    private final DataSource dataSource;

    public DatabaseSourceSession(QueryableInitialisationConfig queryableInitialisationConfig, String url, String userName, String pass, String driverClass) {
        super(queryableInitialisationConfig);
        this.dataSource = createDataSource(url, userName, pass, driverClass);
        configureActualSessionMeta();
    }

    private void configureActualSessionMeta() {
        try {

            final DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
            this.getSessionMeta().put(Database.ActualMetaData.URL_KEY, metaData.getURL());
            this.getSessionMeta().put(Database.ActualMetaData.USER_NAME, metaData.getUserName());
            this.getSessionMeta().put(Database.ActualMetaData.DRIVER_CLASS, metaData.getDriverName());
        } catch (SQLException e) {
            throw new RuntimeException("ERROR::UNABLE TO ESTABLISH A SESSION!", e);
        }
    }

    private DataSource createDataSource(String url, String userName, String pass, String driverClass) {

        if(dataSource == null) {
            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
            driverManagerDataSource.setUrl(url);
            driverManagerDataSource.setUsername(userName);
            driverManagerDataSource.setPassword(pass);
            driverManagerDataSource.setDriverClassName(driverClass);
            return driverManagerDataSource;
        }

        
        return dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
