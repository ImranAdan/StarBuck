package org.adani.starbuck.data;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Utility class to make working with
 * generating SQL statement using NamedJDBCParameters
 */
public class SQLBuilder {

    private final StringBuilder sb;
    private final Map<String, Object> paramMap;

    public SQLBuilder(String... columns) {
        this.sb = new StringBuilder();
        paramMap = new HashMap<>();
        Arrays.stream(columns).forEach(r -> paramMap.put(":" + r, null));
    }

    public SQLBuilder append(String columnName, Object value) {
        paramMap.put(":" + columnName, value);
        return this;
    }

    public String sbSql() {
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public Map<String, ?> getParamMap() {
        return paramMap;
    }
}
