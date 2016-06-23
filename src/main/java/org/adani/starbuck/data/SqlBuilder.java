package org.adani.starbuck.data;

import org.adani.starbuck.utils.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;


/**
 * Utility class to make working with generating SQL statement using NamedJDBCParameters.
 *
 */
public class SQLBuilder {

    private final Map<String, String> paramMap;

    public SQLBuilder(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public Map<String, ?> getParamMap() {
        return paramMap;
    }

    public String completeWhereClause() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            sb.append(entry.getKey() + " = :" + entry.getKey());
        }

        String whereClause = StringUtils.replaceLast(sb.toString(), "AND ", "");
        return whereClause;
    }
}
