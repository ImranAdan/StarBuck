package org.adani.starbuck.domain.source;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Source {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private final String name;
    private final String url;
    private final SourceType sourceType;

    private String description;

    public Source(String name, String description,  SourceType sourceType, String url) {
        this.name = name;
        this.url = url;
        this.sourceType = sourceType;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
