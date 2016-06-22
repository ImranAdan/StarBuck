package org.adani.starbuck.source;

import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.Arrays;
import java.util.List;

public class SourceMappings {

    private static final ResultSetExtractor SOURCE_MAPPING = getMapping();

    public static ResultSetExtractor<Source> extractor() {
        return SOURCE_MAPPING;
    }

    private static ResultSetExtractor<Source> getMapping() {
        return resultSet -> new Source(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("url"),
                SourceType.valueOf(resultSet.getString("source_type")),
                resultSet.getString("description"));
    }

    public static List<String> fields() {
        return Arrays.asList("id", "name", "url", "source_type", "description");
    }
}
