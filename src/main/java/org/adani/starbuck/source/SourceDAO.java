package org.adani.starbuck.source;

import org.adani.starbuck.data.SQLBuilder;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

public class SourceDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(SourceDAO.class);

    @Autowired
    DataSource dataSource;

    public Source fetch(String name) {
        return fetchWithValues(name);
    }

    /**
     * Create a new data source.
     *
     * @param name        Name of the data-source, used for look up
     * @param sourceURL   URL of Data source
     * @param type        What Type of data source it is
     * @param description A brief description containing the purpose of the data source
     * @return A created Data source
     */
    @Transactional
    public Source create(String name, String sourceURL, SourceType type, String description) {

        Source source = fetchWithValues(name, sourceURL, type.toString(), description);
        if (source != null) {
            return source;
        }

        //BEGIN INSERT OPERATION
        final String sql = "INSERT INTO ATHENA.SOURCE (name, url, source_type, description) VALUES (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int updated = new JdbcTemplate(dataSource).update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, name);
            ps.setString(2, sourceURL);
            ps.setString(3, type.toString());
            ps.setString(4, description);
            return ps;
        }, keyHolder);

        LOGGER.info("UPDATE COMPLETE: AFFECTED " + updated + " ROWS");
        Source fetched = fetchWithId(keyHolder.getKey().intValue());
        return fetched;
    }

    private Source fetchWithId(int id) {
        final String sql = "SELECT * FROM ATHENA.SOURCE WHERE id = ?";
        return new JdbcTemplate(dataSource).queryForObject(sql, new Object[]{id}, Source.class);
    }


    private Source fetchWithValues(String... values) {
        try {
            SQLBuilder builder = new SQLBuilder(values);


            /**
             * TODO: fetch with values; generation of sql statement
             */

            final List<String> fields = SourceMappings.fields();
            String fields = String.join(", ", ).trim();

            String sql = "SELECT " + fields.substring(0, fields.length() - 1) + " FROM ATHENA.SOURCE WHERE ";


            return new NamedParameterJdbcTemplate(dataSource).query(builder.sbSql(), builder.getParamMap(), SourceMappings.extractor());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Fetch all persisted data source records
     * @return
     *  A collection of sources
     */
    public List<Source> fetchAll() {
        final String sql = "SELECT * FROM ATHENA.SOURCE";
        return new JdbcTemplate(dataSource).queryForList(sql, Source.class);
    }

    /**
     * TODO: Implement
     * @param s
     * @return
     */
    public Source update(Source s) {
        throw new NotImplementedException("Method yet not implemented");
    }

    /**
     * TODO: Implement
     * @param s
     */
    public void delete(Source s) {
        throw new NotImplementedException("Method yet not implemented");
    }
}
