package org.adani.starbuck.data.jdbc;

import org.adani.starbuck.data.core.Filter;
import org.adani.starbuck.data.core.GenericDAO;
import org.adani.starbuck.data.core.models.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Optional;

public class GenericJDBCDAOImpl<T> implements GenericDAO<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericJDBCDAOImpl.class);

    @Autowired
    DataSource dataSource;


    @Override
    public T fetch(Filter<T> filter) {
        Class<T> type = filter.getFilterType();
        final T item = new JdbcTemplate(dataSource).queryForObject(filter.generateFilterQuery(), type);
        return item;
    }

    @Override
    public Page<T> fetchItems(Filter<T> filter, Optional<Integer> startingIndex, Optional<Integer> pageLimit) {
        return null;
    }

    @Override
    public T create(T item) {
        return null;
    }

    @Override
    public T update(T item) {
        return null;
    }

    @Override
    public void delete(T item) {

    }
}
