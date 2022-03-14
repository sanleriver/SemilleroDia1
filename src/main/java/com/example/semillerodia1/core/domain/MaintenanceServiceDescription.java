package com.example.semillerodia1.core.domain;

import org.apache.commons.lang3.Validate;

public class MaintenanceServiceDescription {

    private final String value;

    public MaintenanceServiceDescription(String value) {
        Validate.notNull(value, "Maintenance service description can't be null.");
        Validate.notBlank(value, "Maintenance service description can't be blank.");
        Validate.isTrue(value.trim().length() <= 512, "Maintenance service description can't be longer than 512");
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
