package com.bpawan.service;

import com.bpawan.service.model.ProvinceMetaData;
import com.google.common.base.Charsets;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.bpawan.util.NumberFormatter.unformatNumber;

@Service
public class ProvinceCsvReader  {

    public List<ProvinceMetaData> read() throws IOException {
        var file = new File("data/provinces.csv");
        var records = CSVParser
                .parse(file, Charsets.UTF_8, CSVFormat.EXCEL)
                .getRecords();

        records.remove(0);

        return records
                .stream()
                .map(this::createPopulationObject)
                .collect(Collectors.toList());
    }

    private ProvinceMetaData createPopulationObject(CSVRecord strings) {
        return ProvinceMetaData
                .builder()
                .sno(unformatNumber(strings.get(0)))
                .name(strings.get(1))
                .headquarter(strings.get(2))
                .area(unformatNumber(strings.get(3)))
                .population(unformatNumber(strings.get(4)))
                .build();
    }
}
