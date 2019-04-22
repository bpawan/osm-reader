package com.bpawan.api.controller;

import com.bpawan.dal.entity.Test;
import com.bpawan.dal.repository.TestRepository;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.LngLatAlt;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {

    private final TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping("test")
    public FeatureCollection test() {
        var featureCollection = new FeatureCollection();

        this.testRepository
                .findAll()
                .forEach(test -> {
                    var feature = new Feature();
                    feature.setGeometry(new org.geojson.Polygon(this.getLngLatAlts(test)));
                    feature.setId(test.getId().toString());
                    feature.setProperty("test", "this is test feature");

                    featureCollection.add(feature);
                });

        return featureCollection;
    }

    private List<LngLatAlt> getLngLatAlts(Test test) {
        return test
                .getPolygon()
                .getPoints()
                .stream()
                .map(point -> new LngLatAlt(point.getX(), point.getY()))
                .collect(Collectors.toList());
    }

    @GetMapping("test/insert")
    public Test insert() {
        var test = new Test();

        var point = new Point(1.23, 2.34);

        Polygon polygon = new Polygon(List.of(point));

        test.setPolygon(polygon);

        return this.testRepository.save(test);
    }
}
