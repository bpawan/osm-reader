package com.bpawan.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProvinceMetaData {

    private Integer sno;

    private String name;

    private String normalizedName;

    private String headquarter;

    private Integer area;

    private Integer population;
}
