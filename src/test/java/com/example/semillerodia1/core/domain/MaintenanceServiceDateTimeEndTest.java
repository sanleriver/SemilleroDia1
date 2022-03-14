package com.example.semillerodia1.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceServiceDateTimeEndTest {
    @Test
    @DisplayName("Invalid datetime start should trhow an error")
    void invalidDatetimeStartTests(){
        LocalDateTime unsafeDate = LocalDateTime.now().plusHours(1);
        assertThrows(IllegalArgumentException.class, () -> {
            new MaintenanceServiceDateTimeStart(unsafeDate);
        });
    }

    @Test
    @DisplayName("Null datetime start should trhow an error")
    void nullDatetimeStartTests(){
        LocalDateTime unsafeDate = null;

        assertThrows(NullPointerException.class, () -> {
            new MaintenanceServiceDateTimeStart(unsafeDate);
        });
    }

    @Test
    @DisplayName("A valid datetime start should not throw an error")
    void validDatetimeStartTest(){
        LocalDateTime validDate = LocalDateTime.now();
        assertDoesNotThrow(() -> {
            new MaintenanceServiceDateTimeStart(validDate);
        });
    }
}