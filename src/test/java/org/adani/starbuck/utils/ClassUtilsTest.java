package org.adani.starbuck.utils;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClassUtilsTest {

    private static final String H2_DRIVER = "H2";

    @Test(expected = Exception.class)
    public void testMake() throws Exception {
        throw new NotImplementedException("Not yet implemented!");

    }

    private Map<Object, Class<?>> getExampleTypeMap() {
        Map<Object, Class<?>> valueTypeMap = new LinkedHashMap<>();
        valueTypeMap.put("H2 DataSource", String.class);
        valueTypeMap.put("Example Configuration Source", String.class);
        valueTypeMap.put(H2_DRIVER, String.class);
        valueTypeMap.put("Fake URL Example", String.class);
        return valueTypeMap;
    }
}