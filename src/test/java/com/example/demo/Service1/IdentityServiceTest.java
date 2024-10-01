package com.example.demo.Service1;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentityServiceTest {

    private IdentityService identityService;

    @BeforeEach
    void setUp() {
        identityService = new IdentityService();
    }

    @Test
    void testVerificarCiExistente_ExistentCi_ReturnsTrue() {
        // Dado
        String existingCi = "1234567";

        // Cuando
        boolean result = identityService.verificarCiExistente(existingCi);

        // Entonces
        assertTrue(result, "El CI existente debería devolver true.");
    }

    @Test
    void testVerificarCiExistente_NonExistentCi_ReturnsFalse() {
        // Dado
        String nonExistingCi = "0000000";

        // Cuando
        boolean result = identityService.verificarCiExistente(nonExistingCi);

        // Entonces
        assertFalse(result, "El CI no existente debería devolver false.");
    }

    @Test
    void testAddIdentidad() {
        // Dado
        Identity newIdentity = new Identity("1111111");

        // Cuando
        identityService.addIdentidad(newIdentity);

        // Entonces
        assertTrue(identityService.verificarCiExistente("1111111"), "El nuevo CI debería ser agregado y ser verificable.");
    }
}
