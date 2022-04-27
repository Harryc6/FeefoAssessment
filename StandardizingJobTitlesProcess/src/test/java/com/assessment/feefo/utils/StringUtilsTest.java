package com.assessment.feefo.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    @Test
    void getFormalStringFromCapitalizedSnakeCase() {
        assertEquals("Hello world", StringUtils.getFormalStringFromCapitalizedSnakeCase("Hello_world"));
        assertEquals("Hello world", StringUtils.getFormalStringFromCapitalizedSnakeCase("HELLO_WORLD"));
        assertEquals("Software engineer", StringUtils.getFormalStringFromCapitalizedSnakeCase("SOFTWARE_ENGINEER"));
    }

}