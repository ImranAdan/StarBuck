package org.adani.starbuck.data.core.sources;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The supported source types.
 * Add additional types
 */
public enum QueryableSourceType {

    DATABASE(),

    SERVICE_END_POINT();

    // Add additional queruable sources below as required



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

}
