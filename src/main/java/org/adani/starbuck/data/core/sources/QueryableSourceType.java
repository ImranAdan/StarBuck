package org.adani.starbuck.data.core.sources;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public enum QueryableSourceType {

    DATABASE(),

    SOAP_END_POINT(),

    JSON_END_POINT();


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

}
