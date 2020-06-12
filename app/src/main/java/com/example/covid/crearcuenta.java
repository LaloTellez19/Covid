package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class crearcuenta extends AppCompatActivity {
    Button guardar, login;
    EditText usuario, email, contraseña, confir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Registro");
        setContentView(R.layout.activity_crearcuenta);
        guardar = (Button) findViewById(R.id.savebtn);
        login = (Button) findViewById(R.id.crearbtn);

        usuario = (EditText) findViewById(R.id.userTxt);
        email = (EditText) findViewById(R.id.emailTxt);
        contraseña = (EditText) findViewById(R.id.passTxt);
        confir = (EditText) findViewById(R.id.conpassTxt);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),login.class);
                startActivityForResult(intent,0);
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
