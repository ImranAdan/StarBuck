package org.adani.starbuck.data.core.sources;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Complete outstanding work on:
 * <p>
 * TODO: https://github.com/ImranAdan/StarBuck/issues/1
 */
public class QueryableSource<QueryableSourceType> {

    private final String url;
    private final String user;
    private final QueryableSourceType sourceType;

    public QueryableSource(String url, String user, QueryableSourceType sourceType) {
        this.url = url;
        this.user = user;
        this.sourceType = sourceType;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public QueryableSourceType getSourceType() {
        return sourceType;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
