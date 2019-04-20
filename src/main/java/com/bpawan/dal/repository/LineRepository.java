package com.bpawan.dal.repository;

import com.bpawan.dal.entity.PlanetOSMLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface LineRepository extends JpaRepository<PlanetOSMLine, BigInteger> {
    @Query(
            value = "SELECT *ü, name, ST_AsText(way) FROM planet_osm_line WHERE name = 'Taplejung' LIMIT 50",
            nativeQuery = true)
    public List<PlanetOSMLine> filterByName();
}
