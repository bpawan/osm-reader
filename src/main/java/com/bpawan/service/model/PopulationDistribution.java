package com.bpawan.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PopulationDistribution {
    private Integer households;

    private Integer total;

    private Integer male;

    private Integer female;
}
