package com.example.semillerodia1.core.domain;

import org.apache.commons.lang3.Validate;

public class MaintenanceServiceId {

    private final String value;

    public MaintenanceServiceId(String value) {
        Validate.notNull(value, "Id of maintenance service can't be null");
        Validate.isTrue(value.trim().length() == 36);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
