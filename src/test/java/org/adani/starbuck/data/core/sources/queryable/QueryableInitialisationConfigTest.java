package org.adani.starbuck.data.core.sources.queryable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context.xml"})
public class QueryableInitialisationConfigTest {


    @Autowired
    QueryableInitialisationConfiguration testDbConfig;

    @Test
    public void testToString() throws Exception {

        assertTrue(testDbConfig.getQueryableType() == QueryableSourceType.DATABASE);

    }
}