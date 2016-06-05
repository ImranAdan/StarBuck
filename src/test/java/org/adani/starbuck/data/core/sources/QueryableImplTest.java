package org.adani.starbuck.data.core.sources;

import org.adani.starbuck.data.core.sources.db.Database;
import org.adani.starbuck.data.core.sources.queryable.Queryable;
import org.adani.starbuck.data.core.sources.queryable.QueryableInitialisationConfiguration;
import org.adani.starbuck.data.core.sources.queryable.QueryableSourceSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context.xml"})
public class QueryableImplTest {

    @Autowired
    private Queryable queryableDatabase;

    @Test
    public void testGetQueryableSourceSession() throws Exception {

        // Get the configuration of the object
        QueryableInitialisationConfiguration queryableInitialisationConfiguration = queryableDatabase.getQueryableInitialisationConfiguration();

        // Get the sessions that is created upon creation of this object
        QueryableSourceSession createdSession = queryableDatabase.getQueryableSourceSession();

        String configuredUser = (String) queryableInitialisationConfiguration.getConfigurations().get(Database.ConfigurationMetaData.USER_NAME);
        String actualUser = (String) createdSession.getSessionMeta().get(Database.ActualMetaData.USER_NAME);

        assertTrue(configuredUser.equals(actualUser));
    }
}