package com.bpawan.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class District {
    private Integer sno;

    private String nameEnglish;

    private String nameNepali;

    private String headquarter;

    private Integer area;

    private Integer population;

    private String website;
}
