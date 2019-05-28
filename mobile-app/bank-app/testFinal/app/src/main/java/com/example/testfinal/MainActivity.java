package com.example.testfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testfinal.Data.AdminSQLite;

public class MainActivity extends AppCompatActivity {

    Button ingresar;
    AdminSQLite helper= new AdminSQLite(this,"Base", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ingresar=(Button)findViewById(R.id.btn_ingresar);
        ingresar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText identificacion = (EditText) findViewById(R.id.id_txt);
                EditText password = (EditText) findViewById(R.id.pass_txt);
                if (identificacion.getText() == null && password.getText() == null) {
                    Toast.makeText(getApplicationContext(), "Campos vacios", Toast.LENGTH_LONG).show();

                } else {



                if (identificacion.getText().equals("") || password.getText().equals("")) {
                    Toast.makeText(getApplicationContext(), "CAMPO VACIO", Toast.LENGTH_LONG).show();
                } else {
                    boolean cursor = helper.validaInformacion(String.valueOf(identificacion.getText()), Integer.valueOf(password.getText().toString()));
                    if (cursor == true) {
                        Toast.makeText(getApplicationContext(), "SATISFACTORIO", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "USUARIO O CONTRASENIA INCORRECTOS", Toast.LENGTH_LONG).show();
                    }
                    identificacion.setText("");
                    password.setText("");
                }
                }
            }});
    }
}
