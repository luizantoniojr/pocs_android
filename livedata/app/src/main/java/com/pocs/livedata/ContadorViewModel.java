package com.pocs.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContadorViewModel extends ViewModel {

    private MutableLiveData<Integer> valor;

    public MutableLiveData<Integer> getValor() {
        if (valor == null)
            valor = new MutableLiveData<Integer>();
        return valor;
    }
}
