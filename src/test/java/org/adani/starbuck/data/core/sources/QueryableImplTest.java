package org.adani.starbuck.data.core.sources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context.xml"})
public class QueryableImplTest {

    @Autowired
    private Queryable queryableDatabase;

    @Test
    public void testGetQueryableSourceSession() throws Exception {
        final QueryableSourceSession queryableSourceSession = queryableDatabase.getQueryableSourceSession();
        QueryableMeta queryableMeta = queryableSourceSession.getQueryableMeta();
        String qName = queryableDatabase.getQueryableName();
        String qMetaName = queryableMeta.getName();
        assertThat("Should be the same", qName.equals(qMetaName));
    }
}