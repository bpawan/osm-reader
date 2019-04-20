package com.bpawan.dal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class District {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "vdc_count")
    private Integer numberOfVDCS;

    @Column(name = "municipality_count")
    private Integer numberOfMunicipalities;

    public District() {
    }

    public Long getId() {
        return id;
    }

    public District setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public District setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getNumberOfVDCS() {
        return numberOfVDCS;
    }

    public District setNumberOfVDCS(Integer numberOfVDCS) {
        this.numberOfVDCS = numberOfVDCS;
        return this;
    }

    public Integer getNumberOfMunicipalities() {
        return numberOfMunicipalities;
    }

    public District setNumberOfMunicipalities(Integer numberOfMunicipalities) {
        this.numberOfMunicipalities = numberOfMunicipalities;
        return this;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfVDCS=" + numberOfVDCS +
                ", numberOfMunicipalities=" + numberOfMunicipalities +
                '}';
    }
}
