package com.bpawan.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardamonProduction {
    private Integer year;
    private String districtName;
    private Double production;
    private String productionUnit;
}
