package org.adani.starbuck.data.core.sources.db;

import org.adani.starbuck.data.core.sources.auth.Authentication;

public interface Database {


    // Authentication
    Authentication<Authentication>


    // Session Meta-Data
    String getLoginUser();


    String getDatabaseName();


    // Operation






}
