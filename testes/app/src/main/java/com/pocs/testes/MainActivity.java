package com.pocs.testes;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText mCpfEditText;
    private Button mValidarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.titulo);

        final Context context = this;

        mCpfEditText = findViewById(R.id.cpfEditText);
        mValidarButton = findViewById(R.id.validarButton);

        mValidarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ValidadorCPF.isCPF(mCpfEditText.getText().toString()))
                    mCpfEditText.setError(getString(R.string.msgCPFInvalido));
                else
                    new AlertDialog
                            .Builder(context)
                            .setTitle(R.string.alertTitle)
                            .setMessage(R.string.alertMensagem)
                            .setPositiveButton(R.string.alertTextPositiveButton, null)
                            .show();
            }
        });
    }
}
