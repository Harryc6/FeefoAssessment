package com.assessment.feefo.enums;

import com.assessment.feefo.utils.StringUtils;

public enum StandardizedJobTitles {
    ARCHITECT,
    SOFTWARE_ENGINEER,
    QUALITY_SURVEYOR,
    ACCOUNTANT;

    @Override
    public String toString() {
        return StringUtils.getFormalStringFromCapitalizedSnakeCase(super.toString());
    }
}
