package com.bpawan.api.controller;

import com.bpawan.dal.repository.VDC;
import com.bpawan.dal.repository.CustomRepository;
import com.bpawan.dal.repository.LineRepository;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lines")
public class LineController {

    private LineRepository lineRepository;
    private CustomRepository customRepository;

    @Autowired
    public LineController(LineRepository lineRepository, CustomRepository customRepository) {
        this.lineRepository = lineRepository;
        this.customRepository = customRepository;
    }

    @GetMapping("list_all")
    public FeatureCollection lines() {


        var lines = this.lineRepository.filterByName();
        FeatureCollection featureCollection = new FeatureCollection();
        var features = lines.stream().map(planetOSMLine -> {
            var feature = new Feature();
            feature.setId(planetOSMLine.getId().toString());
            feature.setProperty("name", planetOSMLine.getName());
            feature.setProperty("way", planetOSMLine.getWay());
            var polygon = new Polygon();
            feature.setGeometry(polygon);

            return feature;
        });

        features.forEach(featureCollection::add);

        return featureCollection;
    }

    @GetMapping(value = "tpj", produces = "application/json")
    public FeatureCollection taplejung() {
        FeatureCollection featureCollection = new FeatureCollection();

        VDC.getVdcList().forEach(vdc -> {
            var districtData = this.customRepository.findWay(vdc);

            if (null != districtData) {

                districtData.getWay().getCoordinates().forEach(lngLatAlts -> {
                    var feature = new Feature();
                    feature.setId("1");
                    feature.setProperty("name", districtData.getName());
                    feature.setProperty("density", 94.65);
                    var poly = new Polygon(lngLatAlts);
                    feature.setGeometry(poly);

                    featureCollection.add(feature);
                });
            }
        });
        return featureCollection;
    }
}
