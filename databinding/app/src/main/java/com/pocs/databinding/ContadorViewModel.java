package com.pocs.databinding;

public class ContadorViewModel {
    private final Integer valor;

    public ContadorViewModel(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor(){
        return this.valor;
    }
}