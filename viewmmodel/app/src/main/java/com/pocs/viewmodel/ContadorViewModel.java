package com.pocs.viewmodel;

import androidx.lifecycle.ViewModel;

public class ContadorViewModel extends ViewModel {
    int valor = 0;

    public int getValor() {
        return valor;
    }

    public void setValor(int novoValor) {
        valor = novoValor;
    }
}