package org.adani.starbuck.source;

import org.adani.starbuck.data.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SourceManager {

    @Autowired
    private SourceDAO sourceDAO;

    public Source create(String name, String url, SourceType type, String description) {
        Source source = sourceDAO.create(name, url, type, description);
        return source;
    }

    public Source update(Source s) {
        Source updatedSource = sourceDAO.update(s);
        return updatedSource;
    }

    public void delete(Source s) {
        sourceDAO.delete(s);
    }

    public Source fetch(Source s) {
        Source fetched = sourceDAO.fetch(s);
        return fetched;
    }

    public List<Source> fetchAll() {
        List<Source> sources = sourceDAO.fetchAll();
        return sources;
    }

    public Page<Source> fetchPage(int start, int limit) {
        final Page<Source> sourcePage = sourceDAO.fetchPage(start, limit);
        return sourcePage;
    }


    public SourceDAO getSourceDAO() {
        return sourceDAO;
    }

    public void setSourceDAO(SourceDAO sourceDAO) {
        this.sourceDAO = sourceDAO;
    }
}
