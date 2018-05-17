package com.leal.personas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leal.personas.DBHelper.DBHelper;
import com.leal.personas.Datos.Persona;

public class Registrar extends AppCompatActivity {
    private EditText textId,txtNombre;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        inicializarControles();
        DBHelper.getInstance(this);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = DBHelper.myDB.add(new Persona(textId.getText().toString(),txtNombre.getText().toString()));
                if(flag){
                    Log.d("Edit",txtNombre.getText().toString());
                }
            }
        });

    }

    public void inicializarControles(){
        btnEnviar = findViewById(R.id.btnRegistrar);
        textId = findViewById(R.id.txtId);
        txtNombre = findViewById(R.id.txtNombre);
    }
}

