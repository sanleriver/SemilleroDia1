package com.example.semillerodia1.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceServiceDateTimeStartTest {
    @Test
    @DisplayName("Invalid datetime end should trhow an error")
    void invalidDatetimeEndTests(){
        LocalDateTime unsafeDate = LocalDateTime.now().plusHours(1);
        assertThrows(IllegalArgumentException.class, () -> {
            new MaintenanceServiceDateTimeEnd(unsafeDate);
        });
    }

    @Test
    @DisplayName("Null datetime end should trhow an error")
    void nullDatetimeEndTests(){
        LocalDateTime unsafeDate = null;

        assertThrows(NullPointerException.class, () -> {
            new MaintenanceServiceDateTimeEnd(unsafeDate);
        });
    }

    @Test
    @DisplayName("A valid datetime end should not throw an error")
    void validDatetimeEndTest(){
        LocalDateTime validDate = LocalDateTime.now();
        assertDoesNotThrow(() -> {
            new MaintenanceServiceDateTimeEnd(validDate);
        });
    }
}