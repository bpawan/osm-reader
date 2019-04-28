package com.bpawan.service.wikipedia;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class GaunPalikaReaderTest {

    @Test
    void downloadFile() throws IOException {
        new GaunPalikaReader().downloadHtmlFile();
    }
}
