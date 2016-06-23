package org.adani.starbuck.source;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

public class SourceMappings {

    private static final List<String> FIELDS = Arrays.asList("id", "name", "url", "source_type", "description");
    private static final RowMapper<Source> ROW_MAPPER = initMapper();
    private static final ResultSetExtractor<Source> EXTRACTOR = initExtractor();

    public static List<String> fields() {
        return FIELDS;
    }

    public static ResultSetExtractor<Source> extractor() {
        return EXTRACTOR;
    }

    public static RowMapper<Source> mapper() {
        return ROW_MAPPER;
    }

    private static ResultSetExtractor<Source> initExtractor() {
        return resultSet -> new Source(resultSet.getLong("id"), resultSet.getString("name"),
                resultSet.getString("url"), SourceType.valueOf(resultSet.getString("source_type")),
                resultSet.getString("description"));
    }

    private static RowMapper<Source> initMapper() {
        return (resultSet, i) -> new Source(resultSet.getLong("id"), resultSet.getString("name"),
                resultSet.getString("url"), SourceType.valueOf(resultSet.getString("source_type")),
                resultSet.getString("description"));
    }
}
