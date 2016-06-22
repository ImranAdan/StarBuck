package org.adani.starbuck.source;

import org.adani.starbuck.data.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SourceManager {

    @Autowired
    private SourceDAO sourceDAO;

    public Source create(String name, String url, SourceType type, String description) {
        return sourceDAO.create(name, url, type, description);
    }

    public Source update(Source s) {
        return sourceDAO.update(s);
    }

    public void delete(Source s) {
        sourceDAO.delete(s);
    }

    public Source fetch(Source s) {
        return sourceDAO.fetch(s);
    }

    public List<Source> fetchAll() {
        return sourceDAO.fetchAll();
    }

    public Page<Source> fetchPage(int start, int limit) {
        return sourceDAO.fetchPage(start, limit);
    }

    public SourceDAO getSourceDAO() {
        return sourceDAO;
    }

    public void setSourceDAO(SourceDAO sourceDAO) {
        this.sourceDAO = sourceDAO;
    }
}
