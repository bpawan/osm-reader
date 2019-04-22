package com.bpawan.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
@Component
public class NumberFormatter {
    public static Integer unformatNumber(String formatted) {
        try {
            return NumberFormat
                    .getNumberInstance(Locale.US)
                    .parse(formatted)
                    .intValue();
        } catch (ParseException exception) {
            log.warn("Unable to create population object" + exception.getClass());
        }

        return 0;
    }
}
