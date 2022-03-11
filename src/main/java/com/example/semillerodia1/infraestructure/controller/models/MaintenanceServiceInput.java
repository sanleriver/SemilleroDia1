package com.example.semillerodia1.infraestructure.controller.models;

import java.time.LocalDateTime;

public class MaintenanceServiceInput {

    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;
    private String description;

    public MaintenanceServiceInput(LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd, String description) {
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.description = description;
    }

    public MaintenanceServiceInput() {
    }

    public LocalDateTime getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(LocalDateTime dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public LocalDateTime getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(LocalDateTime dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
