package com.example.semillerodia1.controller.models;

import com.example.semillerodia1.domain.MaintenanceService;

public class MaintenanceServiceDTO {

    private String id;
    private String dateTimeStart;
    private String dateTimeEnd;
    private String description;

    public MaintenanceServiceDTO(String id, String dateTimeStart, String dateTimeEnd, String description) {
        this.id = id;
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.description = description;
    }

    public MaintenanceServiceDTO() {
    }

    public static MaintenanceServiceDTO fromDomain(MaintenanceService maintenanceService){
        return new MaintenanceServiceDTO(
                maintenanceService.getId().toString(),
                maintenanceService.getDateTimeStart().toString(),
                maintenanceService.getDateTimeEnd().toString(),
                maintenanceService.getDescription().toString()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(String dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public String getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(String dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
