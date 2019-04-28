package com.bpawan.api.controller.agriculture;

import com.bpawan.service.agriculture.cardamom.ProductionParser;
import com.bpawan.service.model.CardamonProduction;
import io.vavr.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agriculture")
public class ProductionController {

    private final ProductionParser cardamomParser;

    public ProductionController(ProductionParser cardamomParser) {
        this.cardamomParser = cardamomParser;
    }

    @GetMapping("cardamom_production")
    public List<List<ArrayList<CardamonProduction>>> getCardamomProduction() throws IOException {



        return this.cardamomParser
                .parse()
                .stream()
                .map(Value::toJavaList)
                .collect(Collectors.toList());
    }
}
