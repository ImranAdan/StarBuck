package org.adani.starbuck.data.core.sources;

import org.adani.starbuck.data.core.sources.db.Database;
import org.adani.starbuck.data.core.sources.queryable.Queryable;
import org.adani.starbuck.data.core.sources.queryable.QueryableInitialisationConfig;
import org.adani.starbuck.data.core.sources.queryable.QueryableSourceSession;
import org.h2.store.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context.xml"})
public class QueryableImplTest {

    @Autowired
    private Queryable queryableDatabase;

    @Test
    public void testGetQueryableSourceSession() throws Exception {

        // Get the configuration of the object
        final QueryableInitialisationConfig queryableInitialisationConfig = queryableDatabase.getQueryableInitialisationConfig();

        // Get the sessions that is created upon creation of this object
        final QueryableSourceSession createdSession = queryableDatabase.getQueryableSourceSession();

        final String configuredUser = (String) queryableInitialisationConfig.getConfigurations().get(Database.ConfigurationMetaData.USER_NAME);
        final String actualUser = (String) createdSession.getSessionMeta().get("actual_user");

        assertTrue(configuredUser.equals(actualUser));
    }
}