package org.adani.starbuck.data.core.sources.queryable;

import org.adani.starbuck.data.core.sources.db.Database;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context.xml"})
public class QueryableImplTest {

    @Autowired
    private Queryable queryableDatabase;

    @Test
    public void testCreateQueryableSourceSession() throws Exception {

        // Get the configuration of the object
        QueryableInitialisationConfiguration queryableInitialisationConfiguration = queryableDatabase.getInitialisationConfiguration();

        // Get the sessions that is created upon creation of this object
        QueryableSession createdSession = queryableDatabase.createQueryableSourceSession();

        String configuredUser = (String) queryableInitialisationConfiguration.getConfigurations().get(Database.ConfigurationMetaData.USER_NAME);
        String actualUser = (String) createdSession.getSessionMeta().get(Database.ActualMetaData.USER_NAME);

        assertThat(createdSession, is(notNullValue()));
        assertTrue(configuredUser.equalsIgnoreCase(actualUser));
    }
}