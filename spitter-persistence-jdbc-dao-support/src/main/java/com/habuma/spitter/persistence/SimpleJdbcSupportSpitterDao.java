package com.habuma.spitter.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

public class SimpleJdbcSupportSpitterDao extends JdbcDaoSupport implements SpitterDao {

    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname, email, update_by_email) values (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_SPITTER = "update spitter set username = ?, password = ?, fullname = ?, set email = ?" + "where id = ?";

    private static final String SQL_SELECT_SPITTER = "" + "select id, username, password, fullname, email from spitter";

    private static final String SQL_SELECT_SPITTER_BY_ID = SQL_SELECT_SPITTER + " where id=?";

    // <start id="java_getSpitterById" />
    public Spitter getSpitterById(long id) {
        Object[] obja = new Object[1];
        obja[0] = id;
        /**
         * Spring 2.5, 3.x 使用
         */
        RowMapper<Spitter> mapper = new RowMapper<Spitter>() {
            public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
                Spitter spitter = new Spitter();
                spitter.setId(rs.getLong(1));
                spitter.setUsername(rs.getString(2));
                spitter.setPassword(rs.getString(3));
                spitter.setFullName(rs.getString(4));
                spitter.setEmail(rs.getString(5));
                return spitter;
            }
        };

        return getJdbcTemplate().queryForObject(SQL_SELECT_SPITTER_BY_ID, obja, mapper);
    }
    // <end id="java_getSpitterById" />

    // <start id="java_addSpitter" />
    public void addSpitter(Spitter spitter) {
        getJdbcTemplate().update(SQL_INSERT_SPITTER, spitter.getUsername(), spitter.getPassword(), spitter.getFullName(), spitter.getEmail(),
                spitter.isUpdateByEmail());
        spitter.setId(queryForIdentity());
    }
    // <end id="java_addSpitter" />

    public void saveSpitter(Spitter spitter) {
        getJdbcTemplate().update(SQL_UPDATE_SPITTER, spitter.getUsername(), spitter.getPassword(), spitter.getFullName(), spitter.getEmail(),

                spitter.getId());
    }

    // <start id="java_queryForIdentity" />
    private long queryForIdentity() {
        return getJdbcTemplate().queryForObject("call identity()", Long.class);
    }
    // <end id="java_queryForIdentity" />

    public List<Spittle> getRecentSpittle() {

        return null;
    }

    public void saveSpittle(Spittle spittle) {

    }

    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return null;
    }

    public Spitter getSpitterByUsername(String username) {

        return null;
    }

    public void deleteSpittle(long id) {
        throw new UnsupportedOperationException();
    }

    public Spittle getSpittleById(long id) {

        return null;
    }

    public List<Spitter> findAllSpitters() {
        return null;
    }
}
