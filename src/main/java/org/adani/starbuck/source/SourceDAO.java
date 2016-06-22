package org.adani.starbuck.source;

import org.adani.starbuck.data.Page;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

public class SourceDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(SourceDAO.class);

    @Autowired
    private DataSource dataSource;

    public Source create(String name, String sourceURL, SourceType type, String description) {

        final String sql = "INSERT INTO ATHENA.SOURCE (name, url, source_type, description) VALUES (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int updated = new JdbcTemplate(dataSource).update(connection ->
        {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, name);
            ps.setString(2, sourceURL);
            ps.setString(3, type.getDriver());
            ps.setString(4, description);
            return ps;
        }, keyHolder);

        LOGGER.info("UPDATE COMPLETE: AFFECTED " + updated + " ROWS");
        Source fetched = fetch(keyHolder.getKey().intValue());
        return fetched;
    }


    public Source update(Source s) {
        throw new NotImplementedException("Method yet not implemented");
    }


    public void delete(Source s) {
        throw new NotImplementedException("Method yet not implemented");
    }


    public Source fetch(Source s) {
        Source fetched = fetch(s.getId());
        return fetched;
    }


    private Source fetch(long sourceId) {
        final String sql = "SELECT * FROM SOURCE WHERE id = ?";
        Source source = new JdbcTemplate(dataSource).queryForObject(sql, new Object[]{sourceId}, Source.class);
        return source;
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
