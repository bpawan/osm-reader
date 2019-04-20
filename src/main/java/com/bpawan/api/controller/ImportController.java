package com.bpawan.api.controller;

import com.bpawan.service.OSMReader;
import com.bpawan.service.OpenDataNepalDistrictReader;
import org.openstreetmap.osmosis.pbf2.v0_6.PbfReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@RestController
@RequestMapping(path = "import", produces = MediaType.APPLICATION_JSON_VALUE)
public class ImportController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final OSMReader osmReader;

    private final OpenDataNepalDistrictReader geoJsonReader;

    public ImportController(OSMReader osmReader, OpenDataNepalDistrictReader geoJsonReader) {
        this.osmReader = osmReader;
        this.geoJsonReader = geoJsonReader;
    }

    @GetMapping("/district")
    public String importDistrictInformation() throws IOException {

        this.geoJsonReader.read();

        return "ok";
    }

    @GetMapping(path = "with_pbf_url")
    public String pbfReader(String url) throws IOException {

        logger.info("received url: " + url);

        InputStream fileInputStream = new FileInputStream(new File("data/nepal-latest.osm.pbf"));

        //http://download.geofabrik.de/asia/lebanon-latest.osm.pbf
        InputStream input = new URL(url).openStream();

        //OsmosisReader reader = new OsmosisReader(input);
        var reader = new PbfReader(new File("data/nepal-latest.osm.pbf"), 4);
        reader.setSink(this.osmReader);
        reader.run();

        return "ok";
    }
}
