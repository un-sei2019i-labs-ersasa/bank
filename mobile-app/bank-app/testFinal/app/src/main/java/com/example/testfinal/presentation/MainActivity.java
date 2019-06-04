package com.example.testfinal.presentation;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testfinal.R;
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
        btn_login =findViewById(R.id.btn_ingresar);
        btn_login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText id = findViewById(R.id.id_txt);
                EditText password = findViewById(R.id.pass_txt);
                if(!id.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                boolean cursor = helper.login(Integer.valueOf(id.getText().toString()),
                        Integer.valueOf(password.getText().toString()));
                if (cursor) {
                    openJoinActivity();
                } else {
                    Toast.makeText(getApplicationContext(), "USUARIO O CONTRASENIA INCORRECTOS", Toast.LENGTH_LONG).show();
                }
                id.setText("");
                password.setText("");
            }
                else{
                    Toast.makeText(getApplicationContext(), "CAMPO VACIO", Toast.LENGTH_LONG).show();
                }
            }});
    }
    public void openJoinActivity(){
        Intent intent = new Intent(this, SendMoneyActivity.class );
        startActivity(intent);
    }
}
