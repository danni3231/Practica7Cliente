package com.example.practica7cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity implements OnMessageListener {

    private Button btnRegistrarse;
    private EditText textCorreo;
    private EditText textClave;
    private EditText textConfirmar;
    private ComunicacionTCP comm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        comm = new ComunicacionTCP();
        comm.solicitarConexion("10.0.2.2");
        comm.setObserver(this);

        btnRegistrarse = findViewById(R.id.btnRegistrarseR);
        textCorreo = findViewById(R.id.textCorreoR);
        textClave = findViewById(R.id.textClaveR);
        textConfirmar = findViewById(R.id.textConfirmar);

        btnRegistrarse.setOnClickListener(
                (view) -> {

                    if(textCorreo.getText().toString().equals("") || textClave.getText().toString().equals("")|| textConfirmar.getText().toString().equals("")){
                        Toast.makeText(this,"Faltan parametros",Toast.LENGTH_LONG).show();
                    }else{
                        String correo =textCorreo.getText().toString();
                        String clave =textClave.getText().toString();
                        String confirmacion =textConfirmar.getText().toString();
                        comm.mandarMensaje("R"+ ","+ correo + "," + clave + "," + confirmacion);
                    }
                }
        );


    }

    public void onMessage(String mensaje) {

        if (mensaje.equals("no")) {
            runOnUiThread(
                    () -> {
                        Toast.makeText(this, "no coinciden las claves", Toast.LENGTH_LONG).show();
                    }
            );
        }

        if(mensaje.equals("si")){
            runOnUiThread(
                    ()->{
                        Toast.makeText(this,"usuario creado",Toast.LENGTH_LONG).show();
                        Intent main = new Intent(RegistroActivity.this,MainActivity.class);
                        startActivity(main);
                    }
            );
        }

    }
}