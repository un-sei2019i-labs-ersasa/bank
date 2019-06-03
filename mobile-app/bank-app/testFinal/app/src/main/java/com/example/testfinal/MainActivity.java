package com.example.testfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testfinal.dataAccess.database.Database;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    Database helper= new Database(this,"Base", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn_login =(Button)findViewById(R.id.btn_ingresar);
        btn_login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText id=(EditText)findViewById(R.id.id_txt);
                EditText password=(EditText)findViewById(R.id.pass_txt);
                  Toast.makeText(getApplicationContext(), password.getText().toString(), Toast.LENGTH_LONG).show();
                    boolean cursor = helper.login(Integer.valueOf(id.getText().toString()),
                            Integer.valueOf(password.getText().toString()));
                    if (cursor) {
                        Toast.makeText(getApplicationContext(), "SATISFACTORIO", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "USUARIO O CONTRASENIA INCORRECTOS", Toast.LENGTH_LONG).show();
                    }
                    id.setText("");
                    password.setText("");
                }});
    }
}
