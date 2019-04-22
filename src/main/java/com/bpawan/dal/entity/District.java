package com.bpawan.dal.entity;

import com.bpawan.dal.types.PostgresHstoreType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Map;

@Entity
@TypeDef(name = "hstore", typeClass = PostgresHstoreType.class)
public class District {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "vdc_count")
    private Integer numberOfVDCS;

    @Column(name = "municipality_count")
    private Integer numberOfMunicipalities;

    @Type(type = "hstore")
    @Column(columnDefinition = "hstore")
    private Map<String, String> features;

    public District() {
    }

    public Map<String, String> getFeatures() {
        return features;
    }

    public void setFeatures(Map<String, String> features) {
        this.features = features;
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
