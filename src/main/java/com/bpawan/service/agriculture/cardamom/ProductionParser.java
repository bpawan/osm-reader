package com.bpawan.service.agriculture.cardamom;

import com.bpawan.service.model.CardamonProduction;
import io.vavr.collection.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.bpawan.util.StringHelper.normalizeString;
import static com.google.common.base.Charsets.UTF_8;

/**
 * Will parse the csv file containing the information of the cardamom production in nepal, per district per year.
 * The reader is fixed for years (2004, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016).
 * If data for another is available than this parser must be adjusted.
 * <p>
 * The data must be inf following format:
 * District,2004,2008,2009,2010,2011,2012,2013,2014,2015,2016
 * Okhaldhunga,3,90,90,80,80,80,4,4,4,6
 *
 */
@Service
public class ProductionParser {

    private static final String FILE_NAME = "data/cardamom_production_by_district.csv";

    private static final List<Integer> YEARS = List.of(2004, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016);

    public java.util.List<List<ArrayList<CardamonProduction>>> parse() throws IOException {
        return readRecords()
                .removeAt(0)
                .map(strings -> List.of(strings).map(this::createCardamomProduction))
                .collect(Collectors.toList());
    }

    private List<CSVRecord> readRecords() throws IOException {
        return List.ofAll(CSVParser.parse(new File(FILE_NAME), UTF_8, CSVFormat.EXCEL).getRecords());
    }

    private ArrayList<CardamonProduction> createCardamomProduction(CSVRecord strings1) {
        var listOfProduction = new ArrayList<CardamonProduction>();
        YEARS.zipWithIndex().forEach(year ->
                listOfProduction.add(
                createObject(
                        year._1, strings1.get(year._2 + 1),
                        normalizeString(strings1.get(0)))
                )
        );

        return listOfProduction;
    }

    private CardamonProduction createObject(Integer year, String production, String districtName) {
        return CardamonProduction
                .builder()
                .districtName(districtName)
                .year(year)
                .productionUnit("Metric Ton")
                .production(Double.valueOf(production))
                .build();
    }
}
