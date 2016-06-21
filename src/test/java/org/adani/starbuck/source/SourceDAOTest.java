package org.adani.starbuck.source;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
public class SourceDAOTest {

    @Autowired
    SourceDAO sourceDAO;

    @Test
    public void testCreate() throws Exception {
        String name = "TEST_TEST";
        String sourceUrl = "TEST_@TEST";
        SourceType type = SourceType.H2;
        String description = "This is a test source type";
        Source source = sourceDAO.create(name, sourceUrl, type, description);
        assertThat(source, is(notNullValue()));
    }

    @Test
    public void testUpdate() throws Exception {
        fail("Test not yet implemented");
    }

    @Test
    public void testDelete() throws Exception {
        fail("Test not yet implemented");
    }

    @Test
    public void testFetch() throws Exception {
        fail("Test not yet implemented");
    }

    @Test
    public void testFetchAll() throws Exception {
        fail("Test not yet implemented");
    }

    @Test
    public void testFetchPage() throws Exception {
        fail("Test not yet implemented");
    }
}