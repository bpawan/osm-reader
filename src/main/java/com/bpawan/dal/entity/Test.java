package com.bpawan.dal.entity;

import org.springframework.data.geo.Polygon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Test {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "polygon")
    private Polygon polygon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }
}
