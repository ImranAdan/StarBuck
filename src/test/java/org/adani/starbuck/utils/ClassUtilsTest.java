package org.adani.starbuck.utils;

import org.adani.starbuck.domain.source.Source;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClassUtilsTest {

    private static final String H2_DRIVER = "H2";
    @Test
    public void testMake() throws Exception {
        Map<Object, Class<?>> valueTypeMap = getExampleTypeMap();
        Source made = ClassUtils.make(Source.class, valueTypeMap);
        System.out.println(made.toString());
        assertThat(made, is(notNullValue()));
    }

    public Map<Object, Class<?>> getExampleTypeMap() {
        Map<Object, Class<?>> valueTypeMap = new LinkedHashMap<>();
        valueTypeMap.put("H2 DataSource", String.class);
        valueTypeMap.put("Example Configuration Source", String.class);
        valueTypeMap.put(H2_DRIVER, String.class);
        valueTypeMap.put("Fake URL Example", String.class);
        return valueTypeMap;
    }
}