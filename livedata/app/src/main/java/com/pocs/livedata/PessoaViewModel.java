package com.pocs.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PessoaViewModel extends ViewModel {

    private MutableLiveData<String> nome;
    private MutableLiveData<String> sobrenome;

    public MutableLiveData<String> getNome() {
        if (nome == null) {
            nome = new MutableLiveData<String>();
        }
        return nome;
    }

    public MutableLiveData<String> getSobrenome() {
        if (sobrenome == null) {
            sobrenome = new MutableLiveData<String>();
        }
        return sobrenome;
    }
}
