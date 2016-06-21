package org.adani.starbuck.source;

/**
 * Represents the set of supported
 * data source types.
 */
public enum SourceType {

    H2("org.h2.Driver");

    private final String driver;

    SourceType(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }
}
