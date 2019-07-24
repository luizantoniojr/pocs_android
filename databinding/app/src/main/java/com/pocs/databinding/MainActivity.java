package com.pocs.databinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.pocs.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ContadorViewModel contadorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        contadorViewModel = new ContadorViewModel(1);
        binding.setModel(contadorViewModel);
    }
}