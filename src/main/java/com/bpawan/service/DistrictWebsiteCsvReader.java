package com.bpawan.service;

import com.bpawan.service.wikipedia.BaseWikipediaParser;
import com.bpawan.service.model.DistrictMetaData;
import com.bpawan.util.NumberFormatter;
import com.google.common.base.Charsets;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictWebsiteCsvReader extends BaseWikipediaParser {

    public List<DistrictMetaData> read() throws IOException {
        var file = new File("data/district_website.csv");
        var records = CSVParser
                .parse(file, Charsets.UTF_8, CSVFormat.EXCEL)
                .getRecords();

        records.remove(0);

        return records
                .stream()
                .map(this::createPopulationObject)
                .collect(Collectors.toList());
    }

    private DistrictMetaData createPopulationObject(CSVRecord strings) {
        System.out.println(strings);
        return DistrictMetaData
                .builder()
                .sno(NumberFormatter.unformatNumber(strings.get(0)))
                .nepaliName(strings.get(1))
                .englishName(strings.get(2))
                .website(strings.get(3))
                .build();
    }
}
