package com.assessment.feefo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class JobStandardizerTest {

    @Test
    void standardize() {
        JobStandardizer js = new JobStandardizer();
        assertEquals("Software engineer", js.standardize("Java engineer"));
        assertEquals("Software engineer", js.standardize("C# engineer"));
        assertEquals("Accountant", js.standardize("Accountant"));
        assertEquals("Accountant", js.standardize("Chief Accountant"));
    }
}