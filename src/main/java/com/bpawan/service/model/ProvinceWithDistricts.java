package com.bpawan.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProvinceWithDistricts {
    private Integer sno;

    private String provinceName;

    private String normalizedProvinceName;

    private String districtName;

    private String normalizedDistrictName;

    private String headquarter;

    private Integer area;

    private Integer population;
}
