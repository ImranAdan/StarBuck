package org.adani.starbuck.source;

import org.adani.starbuck.data.Page;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

public class SourceDAO {

    @Autowired
    private DataSource dataSource;

    public Source create(String name, String sourceURL, SourceType type, String description) {
        throw new NotImplementedException("Method yet not implemented");
    }

    public Source update(Source s) {
        throw new NotImplementedException("Method yet not implemented");
    }

    public void delete(Source s) {
        throw new NotImplementedException("Method yet not implemented");
    }

    public Source fetch(Source s) {
        throw new NotImplementedException("Method yet not implemented");
    }

    public List<Source> fetchAll() {
        throw new NotImplementedException("Method yet not implemented");
    }

    public Page<Source> fetchPage(int start, int limit) {
        throw new NotImplementedException("Method yet not implemented");
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
