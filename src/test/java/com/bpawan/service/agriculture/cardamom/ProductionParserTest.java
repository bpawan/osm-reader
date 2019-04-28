package com.bpawan.service.agriculture.cardamom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ProductionParserTest {
    private ProductionParser productionParser;


    @BeforeEach
    void setup() {
        this.productionParser = new ProductionParser();
    }

    @Test
    void willParseProductionByDistrict() throws IOException {
        var actual = this.productionParser.parse();

    }
}
