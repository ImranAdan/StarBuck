package org.adani.starbuck.data.access.jdbc.sql;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Supported SQL dialects, add additional dielcts as follows.
 */
public enum SupportedSQLDialects {



    H2,
    MySQL;

    // add as required






    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
