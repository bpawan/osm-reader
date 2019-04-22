package com.bpawan.service.wikipedia;

import com.bpawan.service.model.District;
import com.bpawan.service.model.Province;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinceToDistrictMerger {
    private final NameAndWebsiteReader nameAndWebsiteReader;

    private final ProvinceWithDistrictReader provinceWithDistrictReader;
    private String currentProvinceName;
    private List<District> currentDistricts = new ArrayList<>();

    public ProvinceToDistrictMerger(
            NameAndWebsiteReader nameAndWebsiteReader,
            ProvinceWithDistrictReader provinceWithDistrictReader
    ) {
        this.nameAndWebsiteReader = nameAndWebsiteReader;
        this.provinceWithDistrictReader = provinceWithDistrictReader;
    }

    public List<Province> merge() throws Exception {

        var provincesWithDistrict = this.provinceWithDistrictReader.read();
        var districtNameAndWebsite = this.nameAndWebsiteReader.readMetaData();

        if (provincesWithDistrict.size() != districtNameAndWebsite.size()) {
            throw new Exception("the number of districts do not match");
        }

        return io.vavr.collection.List
                .ofAll(provincesWithDistrict)
                .zip(districtNameAndWebsite)
                .map(tuple2 -> {
                    var provinceBuilder = Province.builder();

                    var provinceMetadata = tuple2._1;
                    var districtMetadata = tuple2._2;

                    this.currentProvinceName = provinceMetadata.getNormalizedProvinceName();

                    if (this.currentProvinceName.equals(provinceMetadata.getNormalizedProvinceName())) {
                        var district = District
                                .builder()
                                .sno(districtMetadata.getSno())
                                .area(provinceMetadata.getArea())
                                .population(provinceMetadata.getPopulation())
                                .nameEnglish(districtMetadata.getEnglishName())
                                .nameNepali(districtMetadata.getNepaliName())
                                .website(districtMetadata.getWebsite())
                                .build();

                        this.currentDistricts.add(district);
                    } else {
                        System.out.println("clearing...");
                        this.currentDistricts.clear();
                    }

                    provinceBuilder
                            .name(provinceMetadata.getProvinceName())
                            .districts(this.currentDistricts)
                            .headquarter(provinceMetadata.getHeadquarter())
                            .normalizedName(provinceMetadata.getNormalizedProvinceName());

                    return provinceBuilder.build();
                })
                .collect(Collectors.toList());
    }
}
