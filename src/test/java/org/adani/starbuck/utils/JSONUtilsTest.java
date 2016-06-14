package org.adani.starbuck.utils;

import org.adani.starbuck.domain.source.Source;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharEncoding;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
public class JSONUtilsTest {

    @Test
    public void testCreateInstance() throws Exception {
        String jsonString = getJsonStringFromResources();
        Source a = JSONUtils.createInstance(jsonString, Source.class);
        assertThat(a.getName(), is(notNullValue()));
    }

    public String getJsonStringFromResources() {
        InputStream resourceStream = getClass().getResourceAsStream("source_config.json");
        try {
            return IOUtils.toString(resourceStream, CharEncoding.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("FAILED TO CONVERT!", e);
        }
    }
}