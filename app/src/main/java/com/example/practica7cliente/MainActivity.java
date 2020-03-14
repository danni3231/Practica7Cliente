package com.example.practica7cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnIniciarSesion;
    Button btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnIniciarSesion=findViewById(R.id.btnIniciarSesion);
        btnRegistrarse=findViewById(R.id.btnRegistrarse);

        btnIniciarSesion.setOnClickListener(
                (view)->{
                    Intent iniciarSesion = new  Intent(MainActivity.this,IniciarSesionActivity.class);
                    startActivity(iniciarSesion);
                }
        );

        btnRegistrarse.setOnClickListener(
                (view)->{
                    Intent registro = new  Intent(MainActivity.this,RegistroActivity.class);
                    startActivity(registro);
                }
        );

    }
}
