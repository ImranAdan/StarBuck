package org.adani.starbuck.utils;

import org.adani.starbuck.domain.source.Source;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
public class JSONUtilsTest {


    @Test
    public void testCreateInstance() throws Exception {
        String jsonString = getJsonStringFromResources();
        Source a = JSONUtils.createInstance(jsonString);


    }

    public String getJsonStringFromResources() {

        return null;
    }
}