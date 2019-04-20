package com.bpawan.api.dto;

public class District {
    private Long id;

    private String districtName;

    private Integer numberOfVDCs;

    private Integer numberOfMunicipalities;

    public Long getId() {
        return id;
    }

    public District setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDistrictName() {
        return districtName;
    }

    public District setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }

    public Integer getNumberOfVDCs() {
        return numberOfVDCs;
    }

    public District setNumberOfVDCs(Integer numberOfVDCs) {
        this.numberOfVDCs = numberOfVDCs;
        return this;
    }

    public Integer getNumberOfMunicipalities() {
        return numberOfMunicipalities;
    }

    public District setNumberOfMunicipalities(Integer numberOfMunicipalities) {
        this.numberOfMunicipalities = numberOfMunicipalities;
        return this;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", districtName='" + districtName + '\'' +
                ", numberOfVDCs=" + numberOfVDCs +
                ", numberOfMunicipalities=" + numberOfMunicipalities +
                '}';
    }
}
