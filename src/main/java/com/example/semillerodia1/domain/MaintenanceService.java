package com.example.semillerodia1.domain;

import org.apache.commons.lang3.Validate;

public class MaintenanceService {

    private final MaintenanceServiceId id;
    private final MaintenanceServiceDateTimeStart dateTimeStart;
    private final MaintenanceServiceDateTimeEnd dateTimeEnd;
    private final MaintenanceServiceDescription description;

    public MaintenanceService(MaintenanceServiceId id, MaintenanceServiceDateTimeStart dateTimeStart, MaintenanceServiceDateTimeEnd dateTimeEnd, MaintenanceServiceDescription description) {
        Validate.isTrue(dateTimeEnd.getDateTimeEnd().isAfter(dateTimeStart.getDateTimeStart()));
        this.id = id;
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.description = description;
    }

    public MaintenanceServiceId getId() {
        return id;
    }

    public MaintenanceServiceDateTimeStart getDateTimeStart() {
        return dateTimeStart;
    }

    public MaintenanceServiceDateTimeEnd getDateTimeEnd() {
        return dateTimeEnd;
    }

    public MaintenanceServiceDescription getDescription() {
        return description;
    }
}
