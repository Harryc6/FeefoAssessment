package com.assessment.feefo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStatExtractorTest {

    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();

    @BeforeEach
    void redirectSystemOutStream() {
        System.setOut(new PrintStream(systemOutContent));
    }

    @AfterEach
    void restoreSystemOutStream() {
        System.setOut(originalSystemOut);
    }

    @Test
    void getStats() {
        int[] array = {1, 1, 2, 4, 13, 14, 16, 16, 17, 18, 19, 21, 27, 34, 38, 39, 43, 45, 54};
        new ArrayStatExtractor().getStats(array);
        assertEquals(getExpected1(), systemOutContent.toString().trim());
        systemOutContent.reset();
        array = new int[] {1, 1, 1, 1, 1, 1, 1};
        new ArrayStatExtractor().getStats(array);
        assertEquals(getExpected2(), systemOutContent.toString().trim());
    }

    private String getExpected1() {
        return "Stats extracted from the array generated:\r\n" +
                "    Median: 18.0\r\n" +
                "    Mean: 22.210526315789473\r\n" +
                "    Mode: 1\r\n" +
                "    Range: 1 - 54";
    }

    private String getExpected2() {
        return "Stats extracted from the array generated:\r\n" +
                "    Median: 1.0\r\n" +
                "    Mean: 1.0\r\n" +
                "    Mode: 1\r\n" +
                "    Range: 1 - 1";
    }

}