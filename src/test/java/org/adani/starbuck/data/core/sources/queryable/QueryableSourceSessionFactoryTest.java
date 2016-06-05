package org.adani.starbuck.data.core.sources.queryable;

import org.adani.starbuck.data.core.sources.db.Database;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
public class QueryableSourceSessionFactoryTest {


    @Autowired
    QueryableInitialisationConfiguration testDbConfig;

    @Test
    public void testNewSession() throws Exception {
        final QueryableSourceSession queryableSourceSession = QueryableSourceSessionFactory.newSession(testDbConfig);
        String configuredUser = ((String) testDbConfig.getConfigurations().get(Database.ConfigurationMetaData.USER_NAME)).toLowerCase();
        String sessionUser = ((String) queryableSourceSession.getSessionMeta().get(Database.ActualMetaData.USER_NAME)).toLowerCase();
        assertTrue(sessionUser.equals(configuredUser));
    }
}