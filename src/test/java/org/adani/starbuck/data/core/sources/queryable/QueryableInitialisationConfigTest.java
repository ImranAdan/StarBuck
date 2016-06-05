package org.adani.starbuck.data.core.sources.queryable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

public class QueryableInitialisationConfigTest {

    @Test
    public void testToString() throws Exception {

        Map<String, Object> configMap = new HashMap<>();
        configMap.put("conf_type", "DATABASE");

        QueryableInitialisationConfig config = new QueryableInitialisationConfig("Initialisation Configurations for a H2 DataSource", configMap);

        assertTrue(config.getQueryableType() == QueryableSourceType.DATABASE  );

    }
}