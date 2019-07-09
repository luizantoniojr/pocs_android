package com.pocs.testes;

import java.util.InputMismatchException;

public class ValidadorCPF {

    public static boolean isCPF(String CPF) {
        if (verificarSeCPFContemSomenteNumerosIguais(CPF) || (CPF.length() != 11))
            return (false);
        char resultadoCalculoPrimeiroDigito, resultadoCalculoSegundoDigito;
        try {
            resultadoCalculoPrimeiroDigito = calcularPrimeiroDigito(CPF);
            resultadoCalculoSegundoDigito = calcularSegundoDigito(CPF);
            if (verificarSeDigitoCalculadoConfereComInformado(CPF, resultadoCalculoPrimeiroDigito, resultadoCalculoSegundoDigito))
                return (true);
            else return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    private static boolean verificarSeDigitoCalculadoConfereComInformado(String CPF, char dig10, char dig11) {
        return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
    }

    private static char calcularSegundoDigito(String CPF) {
        return calcularDigito(CPF, 11, 10);
    }

    private static char calcularPrimeiroDigito(String CPF) {
        return calcularDigito(CPF, 10, 9);
    }

    private static char calcularDigito(String CPF, int i2, int i3) {
        int sm;
        int peso;
        int i;
        int num;
        int r;
        char dig10;
        sm = 0;
        peso = i2;
        for (i = 0; i < i3; i++) {
            num = converterValorNaPosicaoIParaInteiro(CPF, i);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else dig10 = converteValorParaRespectivoCaractereNumerico(r);
        return dig10;
    }

    private static char converteValorParaRespectivoCaractereNumerico(int r) {
        return (char) (r + 48);
    }

    private static int converterValorNaPosicaoIParaInteiro(String CPF, int i) {
        int valorDe0NaTabelaASCII = 48;
        return (int) (CPF.charAt(i) - valorDe0NaTabelaASCII);
    }

    private static boolean verificarSeCPFContemSomenteNumerosIguais(String CPF) {
        return CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999");
    }
}