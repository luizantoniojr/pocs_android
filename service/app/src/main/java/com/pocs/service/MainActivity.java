package com.pocs.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoIntentService = findViewById(R.id.botaoIntentService);
        botaoIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentService = new Intent(getApplicationContext(), MeuIntentService.class);
                getApplicationContext().startService(intentService);
            }
        });

        Button botaoService = findViewById(R.id.botaoIntentService);
        botaoService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent service = new Intent(getApplicationContext(), MeuService.class);
                getApplicationContext().startService(service);
            }
        });
    }
}
