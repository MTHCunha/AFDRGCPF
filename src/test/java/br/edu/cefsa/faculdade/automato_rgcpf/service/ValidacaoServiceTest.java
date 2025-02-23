package br.edu.cefsa.faculdade.automato_rgcpf.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidacaoServiceTest {

    private final ValidadorService service = new ValidadorService();

    @Test
    void testCPFValido() {
        assertTrue(service.validar("12345678909"));
    }

    @Test
    void testCPFInvalido() {
        assertFalse(service.validar("12345678"));
    }

    @Test
    void testRGValido() {
        assertTrue(service.validar("123456789"));
    }

    @Test
    void testRGInvalido() {
        assertFalse(service.validar("12345"));
    }
}
