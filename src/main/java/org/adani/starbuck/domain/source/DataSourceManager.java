package org.adani.starbuck.domain.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    public List<Source> getAll(int pageNumber, int pageSize, String sortKey, String direction) {
        List<Source> allSources = sourceRepository.findAllByType(new PageRequest(pageNumber, pageSize, new Sort(Sort.Direction.valueOf(direction), sortKey)));
        return allSources;
    }

    public List<Source> getByType(int pageNumber, int pageSize, String sortKey, String direction) {
        Sort appliedSort = new Sort(Sort.Direction.valueOf(direction), sortKey);
        Pageable pageable = new PageRequest(pageNumber, pageSize, appliedSort);
        List<Source> byType = sourceRepository.findAllByType(pageable);
        return byType;
    }

    private Source make(String name, String description, String sourceType, String url) {
        return new Source(name, description, sourceType, url);
    }

}