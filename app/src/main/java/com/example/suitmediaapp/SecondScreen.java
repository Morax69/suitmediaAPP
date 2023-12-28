package com.example.suitmediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {

    Button btnChoose;
    TextView setNama, btnBack;

    private String nama;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second_screen);

        btnChoose = findViewById(R.id.btnschoose);
        btnBack = findViewById(R.id.btnback);
        setNama = findViewById(R.id.setnama);

        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        setNama.setText(nama);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SecondScreen.this, FirstScreen.class);
                startActivity(intent);
            }
        });

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SecondScreen.this, ThirdScreen.class);
                startActivity(intent);
            }
        });
    }
}