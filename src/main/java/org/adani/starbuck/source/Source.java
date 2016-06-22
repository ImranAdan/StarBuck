package org.adani.starbuck.source;

public class Source {

    private final long id;
    private final String name;
    private final String sourceURL;
    private final SourceType type;
    private String description;

    public Source(long id, String name, String sourceURL, SourceType type, String description) {
        this.id = id;
        this.name = name;
        this.sourceURL = sourceURL;
        this.type = type;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public SourceType getType() {
        return type;
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
}
