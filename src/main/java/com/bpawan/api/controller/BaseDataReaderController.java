package com.bpawan.api.controller;

import com.bpawan.service.model.DistrictMetaData;
import com.bpawan.service.model.ProvinceMetaData;
import com.bpawan.service.model.ProvinceWithDistricts;
import com.bpawan.service.wikipedia.NameAndWebsiteReader;
import com.bpawan.service.wikipedia.ProvinceReader;
import com.bpawan.service.wikipedia.ProvinceToDistrictMerger;
import com.bpawan.service.wikipedia.ProvinceWithDistrictReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("province")
public class BaseDataReaderController {

    private final NameAndWebsiteReader nameAndWebsiteReader;

    private final ProvinceReader provinceReader;

    private final ProvinceWithDistrictReader districtReader;

    private final ProvinceToDistrictMerger merger;

    public BaseDataReaderController(
            NameAndWebsiteReader nameAndWebsiteReader,
            ProvinceReader provinceReader,
            ProvinceWithDistrictReader districtReader,
            ProvinceToDistrictMerger merger
    ) {
        this.nameAndWebsiteReader = nameAndWebsiteReader;
        this.provinceReader = provinceReader;
        this.districtReader = districtReader;
        this.merger = merger;
    }

    @GetMapping("list")
    public List<ProvinceMetaData> listProvinces() throws IOException {
        return this.provinceReader.readProvinces();
    }

    @GetMapping("districts")
    public List<DistrictMetaData> readDistricts() throws IOException {
        return this.nameAndWebsiteReader.readMetaData();
    }

    @GetMapping("with_district")
    public List<ProvinceWithDistricts> readProvincesWithDistrict() throws IOException {
        return this.districtReader.read();
    }

    @GetMapping("merge")
    public List<?> mergedData() throws Exception {
        return this.merger.merge();
    }
}
