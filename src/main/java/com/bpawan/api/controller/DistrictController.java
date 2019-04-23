package com.bpawan.api.controller;

import com.bpawan.api.dto.District;
import com.bpawan.api.mapper.DistrictMapper;
import com.bpawan.dal.repository.DistrictRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/district", produces = MediaType.APPLICATION_JSON_VALUE)
public class DistrictController {

    private final DistrictRepository districtRepository;

    private final DistrictMapper districtMapper;


    public DistrictController(
            DistrictRepository districtRepository,
            DistrictMapper districtMapper
    ) {
        this.districtRepository = districtRepository;
        this.districtMapper = districtMapper;
    }

    @GetMapping("index")
    public List<District> index() {
        return this
                .districtRepository
                .findAll()
                .stream()
                .map(this.districtMapper::fromEntityToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "add", headers = "Accept=application/json")
    public District add(@RequestBody District district) {
        return this
                .districtMapper
                .fromEntityToDTO(
                        this
                                .districtRepository
                                .save(this.districtMapper.fromDTOToEntity(district))
                );
    }

    @GetMapping("features")
    public com.bpawan.dal.entity.District features() {
        var district = new com.bpawan.dal.entity.District();
        district.setName("Taplejung");
        district.setNumberOfMunicipalities(1);
        district.setNumberOfVDCS(100);

        var features = new HashMap<String, String>();

        features.put("population", "1000");
        features.put("area", "200");

        district.setFeatures(features);

        return this.districtRepository.save(district);
    }
}
