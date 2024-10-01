package com.example.demo.Service1;


import com.example.demo.Service1.IdentityController;
import com.example.demo.Service1.IdentityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class IdentityControllerTest {

    @InjectMocks
    private IdentityController identityController;

    @Mock
    private IdentityService identityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testVerificarCi_ExistentCi_ReturnsTrue() {
        // Dado
        String existingCi = "1234567";
        when(identityService.verificarCiExistente(existingCi)).thenReturn(true);

        // Cuando
        ResponseEntity<Boolean> response = identityController.verificarCi(existingCi);

        // Entonces
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
    }

    @Test
    void testVerificarCi_NonExistentCi_ReturnsFalse() {
        // Dado
        String nonExistingCi = "0000000";
        when(identityService.verificarCiExistente(nonExistingCi)).thenReturn(false);

        // Cuando
        ResponseEntity<Boolean> response = identityController.verificarCi(nonExistingCi);

        // Entonces
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody());
    }

    @Test
    void testAgregarIdentidad() {
        // Dado
        Identity newIdentity = new Identity("1111111");

        // Cuando
        ResponseEntity<Void> response = identityController.agregarIdentidad(newIdentity);

        // Entonces
        verify(identityService, times(1)).addIdentidad(any(Identity.class));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
