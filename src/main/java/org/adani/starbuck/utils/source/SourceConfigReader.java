package org.adani.starbuck.utils.source;

import org.adani.starbuck.domain.source.Source;
import org.adani.starbuck.utils.JSONUtils;

public final class SourceConfigReader {

    public static Source toSource(String jsonConfig){
        final Source instance = JSONUtils.createInstance(jsonConfig, Source.class);
        return instance;
    }
}
