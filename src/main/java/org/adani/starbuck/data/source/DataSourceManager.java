package org.adani.starbuck.data.source;

import org.adani.starbuck.domain.source.Source;
import org.springframework.beans.factory.annotation.Autowired;

public class DataSourceManager {

    @Autowired
    SourceRepository sourceRepository;

    public Source create(String name, String description, String sourceType, String url) {
        Source source = make(name, description, sourceType, url);
        final Source instance = sourceRepository.save(source);
        return instance;
    }

    public Source update(String name, String description, String sourceType, String url) {
        return create(name, description, sourceType, url);
    }

    public void delete(Source source) {
        sourceRepository.delete(source);
    }

    public Source getByName(String name) {
        Source source = sourceRepository.findByName(name);
        return source;
    }

    private Source make(String name, String description, String sourceType, String url) {
        return new Source(name, description, sourceType, url);
    }

}