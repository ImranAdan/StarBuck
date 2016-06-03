package org.adani.starbuck.data.access.jdbc;

import org.adani.starbuck.data.core.filters.AbstractEntityFilter;
import org.adani.starbuck.data.core.entities.AbstractEntityDAO;
import org.adani.starbuck.data.core.models.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class JDBCEntityDAO<T> implements AbstractEntityDAO<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCEntityDAO.class);

    @Autowired
    DataSource dataSource;

    @Override
    public T fetch(AbstractEntityFilter<T> filter) {
        Class<T> type = filter.getFilterType();
        LOGGER.info("Fetching <"+type.getSimpleName() +"> With AbstractEntityFilter:" + filter.toString());
        T item = new JdbcTemplate(dataSource).queryForObject(filter.generateQuery(), type);
        return item;
    }

    @Override
    public Page<T> fetchItems(AbstractEntityFilter<T> filter) {
        throw new UnsupportedOperationException("Not Yet implemented");
    }

    @Override
    public T create(T item) {
        throw new UnsupportedOperationException("Not Yet implemented");
    }

    @Override
    public T update(T item) {
        throw new UnsupportedOperationException("Not Yet implemented");
    }

    @Override
    public void delete(T item) {
        throw new UnsupportedOperationException("Not Yet implemented");
    }
}
