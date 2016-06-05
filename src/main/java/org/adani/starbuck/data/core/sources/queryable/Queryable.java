package org.adani.starbuck.data.core.sources.queryable;

public interface Queryable {


    /**
     * Get the configuration specification for
     * the queryable enitiy.
     * @return
     *      Configuration information on the specific
     *      queryable entity.
     */
    QueryableInitialisationConfiguration getQueryableInitialisationConfiguration();



    /**
     * Get the session that is created upon the creation of the
     * queryable source. Session are established by making
     * use of the configuration information associated
     * with the queryable.
     */
    QueryableSourceSession createQueryableSourceSession() throws Exception;



}
