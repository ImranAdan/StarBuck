package org.adani.starbuck.data.access.jdbc;

/**
 * Access mechanism to a datasource
 * by default the access mechansim is readonly.
 */
public enum AccessType {

    READ(), // READ-ONLY
    WRITE() // READ-WRITE

}
