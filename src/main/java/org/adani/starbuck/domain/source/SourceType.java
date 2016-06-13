package org.adani.starbuck.domain.source;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public enum SourceType {

    H2("org.h2.Driver");

    private final String connector;

    SourceType(String connector) {
        this.connector = connector;
    }

    public String getConnector() {
        return connector;
    }

    @Override
    public String toString() {
        return  ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
