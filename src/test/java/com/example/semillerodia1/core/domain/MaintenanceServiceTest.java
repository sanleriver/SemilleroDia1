package com.example.semillerodia1.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceServiceTest {
    @Test
    @DisplayName("Invalid date end before date start should trhow an error")
    void invalidMaintenanceServiceTests(){
        String id = UUID.randomUUID().toString();
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now().minusDays(2);
        String description = "Esta es la descripcion valida";
        assertThrows(IllegalArgumentException.class, () -> {
            new MaintenanceService(new MaintenanceServiceId(id),
                    new MaintenanceServiceDateTimeStart(start),
                    new MaintenanceServiceDateTimeEnd(end),
                    new MaintenanceServiceDescription(description));
        });
    }

    @Test
    @DisplayName("A valid date end after date start should not throw an error")
    void validMaintenanceServiceTests(){
        String id = UUID.randomUUID().toString();
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now().minusHours(2);
        String description = "Esta es la descripcion valida";
        assertDoesNotThrow(() -> {
            new MaintenanceService(new MaintenanceServiceId(id),
                    new MaintenanceServiceDateTimeStart(start),
                    new MaintenanceServiceDateTimeEnd(end),
                    new MaintenanceServiceDescription(description));
        });
    }
}