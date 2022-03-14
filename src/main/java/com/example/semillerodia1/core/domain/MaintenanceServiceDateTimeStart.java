package com.example.semillerodia1.core.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class MaintenanceServiceDateTimeStart {

    private final LocalDateTime value;

    public MaintenanceServiceDateTimeStart(LocalDateTime value) {
        Validate.notNull(value, "Start datetime of maintenance service can't be null");
        Validate.isTrue(value.isBefore(LocalDateTime.now()));
        this.value = value;
    }

    public LocalDateTime getDateTimeStart() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value +"";
    }
}
