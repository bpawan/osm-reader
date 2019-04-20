package com.bpawan.dal.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Polygon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustomRepository {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private NamedParameterJdbcTemplate template;

    @Autowired
    public CustomRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public DistrictData findWay(String vdc) {
        var sql = "SELECT name, ST_AsGeoJSON(ST_Transform(way, 4326), 3857) FROM planet_osm_polygon WHERE name = '" + vdc + "'";

        return this.template.query(sql, rs -> {
            try {
                return createDistrictData(rs, vdc);
            } catch (IOException e) {
                return null;
            }
        });
    }

    private DistrictData createDistrictData(ResultSet rs, String vdc) throws java.io.IOException, SQLException {
        if(rs.next()) {
            var objectMapper = new ObjectMapper();
            var mappedObject = objectMapper.readValue(rs.getString(2), Polygon.class);
            return new DistrictData(rs.getString(1), mappedObject);

        } else {
            log.warn("no data found for provided vdc: " + vdc);
            return null;
        }
    }
}

