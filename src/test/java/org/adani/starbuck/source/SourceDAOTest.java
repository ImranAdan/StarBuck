package org.adani.starbuck.source;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
public class SourceDAOTest {

    @Autowired
    SourceDAO sourceDAO;

    @Test(expected = RuntimeException.class)
    public void testCreate() throws Exception {
        String name = "TEST_TEST";
        String sourceUrl = "TEST_@TEST";
        SourceType type = SourceType.H2;
        String description = "This is a test source type";
        Source source = sourceDAO.create(name, sourceUrl, type, description);
        assertThat(source.getId(), is(notNullValue()));
    }

    @Test
    public void testFetch() throws Exception {
        String name = "TEST_TEST";
        final Source fetched = sourceDAO.fetch(name);
        assertThat(fetched.getId(), is(notNullValue()));
    }

    @Test
    public void testFetchAll() throws Exception {
        final List<Source> sources = sourceDAO.fetchAll();
        assertThat(sources, is(notNullValue()));
    }

    @Ignore
    @Test
    public void testUpdate() throws Exception {
        fail("Test not yet implemented");
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        fail("Test not yet implemented");
    }

    @Ignore
    @Test
    public void testFetchPage() throws Exception {
        fail("Test not yet implemented");
    }
}