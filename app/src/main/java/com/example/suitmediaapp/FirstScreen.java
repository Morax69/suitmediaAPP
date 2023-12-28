package com.example.suitmediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstScreen extends AppCompatActivity {

    Button btnNext, btnCheck;
    EditText txtviewname, txtviewpalindrome;

    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first_screen);

        btnNext = findViewById(R.id.btnnext);
        btnCheck = findViewById(R.id.btncheck);
        txtviewname = findViewById(R.id.name);
        txtviewpalindrome = findViewById(R.id.palindrome);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char[] inputChar = txtviewpalindrome.getText().toString().toCharArray();
                int panjangInt = inputChar.length;

                boolean palindrome = true;

                for (int i=0; i<panjangInt/2; i++){
                    if(inputChar[i] != inputChar[panjangInt-1-i]){
                        palindrome = false;
                        break;
                    }
                }

                if (palindrome){
                    Toast.makeText(getApplicationContext(), "Kalimat Merupakan palindrom", Toast.LENGTH_LONG).show();
                }

                else{
                    Toast.makeText(getApplicationContext(), "Kalimat Bukan Palindrome", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String nama = txtviewname.getText().toString();
                    if (nama != null && nama != ""){
                        Intent i = new Intent(FirstScreen.this, SecondScreen.class);
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);

                    } else {
                        Toast.makeText(getApplication(), "Masukkan Nama!",Toast.LENGTH_SHORT);
                    }

                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "ERROR, TRY AGAIN !",Toast.LENGTH_SHORT);
                }

            }
        });
    }
}