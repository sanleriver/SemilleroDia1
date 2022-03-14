package com.example.semillerodia1.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceServiceIdTest {

    @Test
    @DisplayName("Invalid maintenanceServiceId should trhow an error")
    void invalidMaintenanceServiceIdTests(){
        String unsafeID = "";
        String unsafeID2 = "          ";
        assertThrows(IllegalArgumentException.class, () -> {
           new MaintenanceServiceId(unsafeID);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new MaintenanceServiceId(unsafeID2);
        });
    }

    @Test
    @DisplayName("Null maintenanceServiceId should trhow an error")
    void nullMaintenanceServiceIdTests(){
        String unsafeId = null;

        assertThrows(NullPointerException.class, () -> {
            new MaintenanceServiceId(unsafeId);
        });
    }

    @Test
    @DisplayName("A valid ID should not throw an error")
    void validIdTest(){
        String validId = UUID.randomUUID().toString();
        assertDoesNotThrow(() -> {
            new MaintenanceServiceId(validId);
        });
    }
}