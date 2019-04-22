package com.bpawan.service.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Population {
    private Integer sno;

    private String districtName;

    private Integer households;

    private Integer total;

    private Integer male;

    private Integer female;
}
