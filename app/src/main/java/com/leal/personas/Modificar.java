package com.leal.personas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.leal.personas.DBHelper.DBHelper;
import com.leal.personas.Datos.Persona;

public class Modificar extends AppCompatActivity {
    private EditText id,nombre;
    private Button btnBuscar,btnEliminar,btnActualizar,btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        inicializarControles();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona P = DBHelper.myDB.findUser(id.getText().toString());
                if(P==null){
                    Toast.makeText(getApplicationContext(),"El usuario no fue encontrado", Toast.LENGTH_SHORT).show();
                    limpiar();
                }
                else{
                    nombre.setText(P.getNombre());
                }
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.editUser(new Persona(id.getText().toString(),nombre.getText().toString()));
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.deleteUser(id.getText().toString());
                limpiar();;
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();;
            }
        });

    }

    public void inicializarControles(){
        id = findViewById(R.id.txtIdM);
        nombre = findViewById(R.id.txtNombreM);
       btnBuscar = findViewById(R.id.btnBuscarM);
        btnEliminar = findViewById(R.id.btnEliminarM);
        btnActualizar = findViewById(R.id.btnActualizarM);
        btnLimpiar = findViewById(R.id.btnLimpiarM);
    }

    public void limpiar(){
        nombre.setText("");
        id.setText("");
    }
}
