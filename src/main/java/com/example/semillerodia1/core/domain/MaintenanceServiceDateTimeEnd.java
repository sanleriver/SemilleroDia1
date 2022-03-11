package com.example.semillerodia1.core.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class MaintenanceServiceDateTimeEnd {

    private final LocalDateTime value;

    public MaintenanceServiceDateTimeEnd(LocalDateTime value) {
        Validate.notNull(value, "End datetime of maintenance service can't be null");
        Validate.isTrue(value.isBefore(LocalDateTime.now()));
        this.value = value;
    }

    public LocalDateTime getDateTimeEnd() {
        return value;
    }

    @Override
    public String toString() {
        return "MaintenanceServiceDateTimeStrat{" +
                "dateTimeStart=" + value +
                '}';
    }
}
