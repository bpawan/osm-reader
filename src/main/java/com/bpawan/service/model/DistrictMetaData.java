package com.bpawan.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DistrictMetaData {
    private Integer sno;

    private String normalizedName;

    private String nepaliName;

    private String englishName;

    private String website;
}
