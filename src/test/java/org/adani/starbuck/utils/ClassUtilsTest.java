package org.adani.starbuck.utils;

import org.adani.starbuck.domain.source.Source;
import org.adani.starbuck.domain.source.SourceType;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClassUtilsTest {

    /**
     * TODO: INVESTIAGET WHY BELOW IS NOT PASSING
     */

    @Test
    public void testMake() throws Exception {
        Map<Object, Class<?>> valueTypeMap = new LinkedHashMap<>();

        valueTypeMap.put("H2 DataSource", String.class);
        valueTypeMap.put("Example Configuration Source", String.class);
        valueTypeMap.put(SourceType.H2.getConnector(), SourceType.class);
        valueTypeMap.put("Fake URL Example", String.class);

        Source made = ClassUtils.make(Source.class, valueTypeMap);
        System.out.println(made.toString());
        assertThat(made, is(notNullValue()));
    }
}