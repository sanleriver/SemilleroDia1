package com.example.semillerodia1.infrastructure.gateways.models;

import com.example.semillerodia1.core.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MaintenanceServiceDBO {

    private String id;
    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;
    private String description;

    public MaintenanceServiceDBO(String id, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd, String description) {
        this.id = id;
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.description = description;
    }

    public MaintenanceServiceDBO() {
    }

    public MaintenanceService toDomain(){
        return new MaintenanceService(
                new MaintenanceServiceId(id),
                new MaintenanceServiceDateTimeStart(dateTimeStart),
                new MaintenanceServiceDateTimeEnd(dateTimeEnd),
                new MaintenanceServiceDescription(description)
        );
    }

    public static MaintenanceServiceDBO fromDomain(MaintenanceService maintenanceService){
        return new MaintenanceServiceDBO(
                maintenanceService.getId().toString(),
                maintenanceService.getDateTimeStart().getDateTimeStart(),
                maintenanceService.getDateTimeEnd().getDateTimeEnd(),
                maintenanceService.getDescription().toString()
        );
    }

    public static MaintenanceServiceDBO fromResultSet(ResultSet resultSet) throws SQLException{
        MaintenanceServiceDBO maintenanceServiceDBO = new MaintenanceServiceDBO();
        maintenanceServiceDBO.setId(resultSet.getString("maintenance_id"));
        maintenanceServiceDBO.setDateTimeStart(resultSet.getTimestamp("maintenance_datetimestart").toLocalDateTime());
        maintenanceServiceDBO.setDateTimeEnd(resultSet.getTimestamp("maintenance_datetimeend").toLocalDateTime());
        maintenanceServiceDBO.setDescription(resultSet.getString("maintenance_description"));
        return maintenanceServiceDBO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
