package org.adani.starbuck.data.core.sources.support;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Supported SQL dialects, add additional dielcts as follows.
 */
public enum SupportedSQLDialects {


    // Statementbuilder here
    H2,
    MySQL;


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
