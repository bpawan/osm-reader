package com.bpawan.api.mapper;

import org.springframework.stereotype.Component;

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
        return new com.bpawan.dal.entity.District()
                .setId(district.getId())
                .setName(district.getDistrictName())
                .setNumberOfVDCS(district.getNumberOfVDCs())
                .setNumberOfMunicipalities(district.getNumberOfMunicipalities());
    }
}
