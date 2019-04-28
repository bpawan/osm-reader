package com.bpawan.dal.administrative.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ProvincePopulation {
    @Id
    @GeneratedValue
    private Long id;

    private Double total;

    private Integer rank;

    private Double density;

    private Integer densityRank;

    private Long province_id;
}
