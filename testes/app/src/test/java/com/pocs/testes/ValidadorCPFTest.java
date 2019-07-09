package com.pocs.testes;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidadorCPFTest {

    @Test
    public void deveRetornarFalsePoisCPFContemSomenteNumerosIguais() {
        String cpf = "11111111111";

        boolean retorno = ValidadorCPF.isCPF(cpf);

        assertFalse(retorno);
    }

    @Test
    public void deveRetornarFalsePoisCPFNaoContemOnzeDigitos() {
        String cpf = "100407006311";

        boolean retorno = ValidadorCPF.isCPF(cpf);

        assertFalse(retorno);
    }

    @Test
    public void deveRetornarFalsePoisCPFVazio() {
        String cpf = "";

        boolean retorno = ValidadorCPF.isCPF(cpf);

        assertFalse(retorno);
    }

    @Test
    public void deveRetornarFalsePoisCPFContemLetras() {
        String cpf = "ABCDEFGHIJK";

        boolean retorno = ValidadorCPF.isCPF(cpf);

        assertFalse(retorno);
    }

    @Test
    public void deveRetornarFalsePoisCPFInvalido() {
        String cpf = "10040700632";

        boolean retorno = ValidadorCPF.isCPF(cpf);

        assertFalse(retorno);
    }

    @Test
    public void deveRetornarTruePoisCPFValido() {
        String cpf = "10040700631";

        boolean retorno = ValidadorCPF.isCPF(cpf);

        assertTrue(retorno);
    }
}