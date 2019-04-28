package com.bpawan.api.controller.administrative;

import com.bpawan.api.controller.ResourceNotFoundException;
import com.bpawan.dal.administrative.entity.Province;
import com.bpawan.dal.administrative.repository.ProvinceRepository;
import com.bpawan.util.StringHelper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.lang.String.format;

@RestController
@RequestMapping("/administrative/province")
public class ProvinceController {

    private final ProvinceRepository provinceRepository;

    public ProvinceController(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("index")
    public List<Province> listAll() {
        return this.provinceRepository.findAll();
    }

    @PutMapping("find/{provinceId}")
    public Province getById(@PathVariable Long id) {
        return this.provinceRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format("Province with %s not found", id)));
    }

    @PutMapping("update/{provinceId}")
    public Province update(@PathVariable Long provinceId, @Valid @RequestBody Province provinceRequest) {
        return this
                .provinceRepository
                .findById(provinceId)
                .map(province -> {
                            province.setEnglishName(provinceRequest.getEnglishName());
                            province.setNepaliName(provinceRequest.getNepaliName());
                            province.setNormalizedName(StringHelper.normalizeString(province.getEnglishName()));
                            province.setCapitalCity(provinceRequest.getCapitalCity());
                            province.setWebsite(provinceRequest.getWebsite());
                            province.setDistrictCount(provinceRequest.getDistrictCount());
                            province.setArea(provinceRequest.getArea());
                            province.setAreaRank(provinceRequest.getAreaRank());
                            //province.setElevation(provinceRequest.getElevation());
                            province.setFeatures(provinceRequest.getFeatures());

                            return this.provinceRepository.save(province);
                        }
                )
                .orElseThrow(() -> new ResourceNotFoundException(format("Province with %s not found", provinceId)));
    }
}
