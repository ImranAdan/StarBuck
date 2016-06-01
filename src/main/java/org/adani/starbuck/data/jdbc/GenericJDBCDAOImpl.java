package org.adani.starbuck.data.jdbc;

import org.adani.starbuck.data.core.Filter;
import org.adani.starbuck.data.core.GenericDAO;
import org.adani.starbuck.data.core.models.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class GenericJDBCDAOImpl<T> implements GenericDAO<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericJDBCDAOImpl.class);

    @Autowired
    DataSource dataSource;

    @Override
    public T fetch(Filter<T> filter) {
        Class<T> type = filter.getFilterType();
        LOGGER.info("Fetching <"+type.getSimpleName() +"> With Filter:" + filter.toString());
        T item = new JdbcTemplate(dataSource).queryForObject(filter.generateQuery(), type);
        return item;
    }

    @Override
    public Page<T> fetchItems(Filter<T> filter) {
        Class<T> type = filter.getFilterType();
        LOGGER.info("Fetching Page of <"+type.getSimpleName() +"> With Filter:" + filter.toString());
        List<T> pageItems = new JdbcTemplate(dataSource).queryForList(filter.generateQuery(), type);
        Page<T> page = new Page<>(pageItems);
        return page;
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
