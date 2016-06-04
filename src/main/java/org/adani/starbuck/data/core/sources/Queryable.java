package org.adani.starbuck.data.core.sources;

import org.adani.starbuck.data.core.sources.auth.Authentication;

import java.net.URL;


public interface Queryable {

    /**
     * Establish a session to a Queryable
     * source. Once a session is established
     * the read or edit actions can be
     * performed on queryable source.
     */
    QueryableSourceSession getQueryableSourceSession();


}
