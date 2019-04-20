package com.bpawan.dal.repository;

import org.geojson.Polygon;

public class DistrictData {
    private String name;

    private Polygon way;

    DistrictData(String name, Polygon way) {
        this.name = name;
        this.way = way;
    }

    public Polygon getWay() {
        return way;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DistrictData{" +
                "name='" + name + '\'' +
                ", way=" + way.toString() +
                '}';
    }
}
