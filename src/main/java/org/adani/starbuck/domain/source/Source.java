package org.adani.starbuck.domain.source;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Source implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "source_type")
    private SourceType sourceType;

    @Column(name = "description")
    private String description;

    public Source(String name, String description, String sourceType, String url) {
        this.name = name;
        this.url = url;
        this.sourceType = SourceType.valueOf(sourceType);
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

    public long getId() {
        return id;
    }


    @Override
    public boolean equals(final Object obj) {

        if ((obj == null)
                || !(obj instanceof Source))
            return false;

        final Source other = (Source) obj;
        return new EqualsBuilder().append(getName(), other.getName())
                .append(getDescription(), other.getDescription())
                .append(getSourceType(), other.getSourceType())
                .append(getUrl(), other.getUrl())
                .isEquals();

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getName())
                .append(getDescription())
                .append(getSourceType()).toHashCode();
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

}
