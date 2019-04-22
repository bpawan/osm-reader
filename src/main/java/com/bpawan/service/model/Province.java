package com.bpawan.service.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Province {
    private Integer sno;

    private String name;

    private String normalizedName;

    private String headquarter;

    private String normalizedHeadquarter;

    private List<District> districts;

    private Integer area;

    private Integer population;
}
