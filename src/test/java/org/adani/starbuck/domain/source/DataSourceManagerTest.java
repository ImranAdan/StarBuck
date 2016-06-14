package org.adani.starbuck.domain.source;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
public class DataSourceManagerTest {

    @Autowired
    DataSourceManager dataSourceManager;

    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testGetByName() throws Exception {

    }

    @Test
    public void testGetByType() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {

    }


    private Source getConfigurationsFromResources() {
        return null;

    }

}