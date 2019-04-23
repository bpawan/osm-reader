package com.bpawan.service.geojson;

import com.bpawan.dal.entity.District;
import com.bpawan.dal.repository.DistrictRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.geojson.FeatureCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class OpenDataNepalDistrictReader {

    private final DistrictRepository districtRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${opendatanepal.dataset.district.geojson}")
    private String districtGeoJsonFileUrl;

    public OpenDataNepalDistrictReader(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public void read() throws IOException {

        var objectMapper = new ObjectMapper();
        System.out.println(this.districtGeoJsonFileUrl);

        var uri = new URL(this.districtGeoJsonFileUrl);

        var featureCollection = objectMapper.readValue(uri, FeatureCollection.class);

        var featureList = Lists.newArrayList(featureCollection.getFeatures());

        featureList.forEach(feature -> {
            var districtName = feature.getProperties().get("district");
            var district = new District();
            district.setName(districtName.toString());

            this.districtRepository.save(district);

            logger.info("district: " + district.getName() + "imported...");
        });
    }
}
