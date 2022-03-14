package com.example.semillerodia1.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceServiceDescriptionTest {
    @Test
    @DisplayName("Invalid description should trhow an error")
    void invalidDescriptionTests(){
        String unsafeDescription = "";
        String unsafeDescription2 = "          ";
        String unsafeDescription3 = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado e";
        assertThrows(IllegalArgumentException.class, () -> {
            new MaintenanceServiceDescription(unsafeDescription);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new MaintenanceServiceDescription(unsafeDescription2);
        });
    }

    @Test
    @DisplayName("Null description should trhow an error")
    void nullDescriptionTests(){
        String unsafeDescription = null;

        assertThrows(NullPointerException.class, () -> {
            new MaintenanceServiceDescription(unsafeDescription);
        });
    }

    @Test
    @DisplayName("A valid description should not throw an error")
    void validDescriptionTest(){
        String validDescription = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado ";
        assertDoesNotThrow(() -> {
            new MaintenanceServiceDescription(validDescription);
        });
    }
}