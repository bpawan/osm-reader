package com.bpawan.api.mapper;

import com.bpawan.dal.entity.District;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DistrictMapper {
    public com.bpawan.api.dto.District fromEntityToDTO(com.bpawan.dal.entity.District district) {
        return new com.bpawan.api.dto.District()
                .setId(district.getId())
                .setDistrictName(district.getName())
                .setNumberOfVDCs(district.getNumberOfVDCS())
                .setNumberOfMunicipalities(district.getNumberOfMunicipalities());
    }

    public com.bpawan.dal.entity.District fromDTOToEntity(com.bpawan.api.dto.District district) {
        var testHash = new HashMap<String, String>();
        testHash.put("test", "test");
        return District.builder()
                .id(district.getId())
                .name(district.getDistrictName())
                .numberOfVDCS(district.getNumberOfVDCs())
                .features(testHash)
                .numberOfMunicipalities(district.getNumberOfMunicipalities())
                .build();
    }
}
