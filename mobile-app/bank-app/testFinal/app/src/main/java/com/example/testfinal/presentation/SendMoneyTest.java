package com.example.testfinal.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testfinal.R;
import com.example.testfinal.businessLogic.SendMoneyController;
import com.example.testfinal.dataAccess.models.User;

public class SendMoneyTest extends AppCompatActivity {
    Button send_button;
    //TEST MAILER
    int mailer= 123456;
    SendMoneyController send= new SendMoneyController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money_test);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        send_button=findViewById(R.id.send_button);
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText reciever = findViewById(R.id.txt_reciever);
                EditText ammount= findViewById(R.id.trans_ammount);
                if(!reciever.getText().toString().isEmpty() && !ammount.getText().toString().isEmpty()){
                    if(send.sendMoney(mailer,Integer.valueOf(reciever.getText().toString()),
                            Float.valueOf(ammount.getText().toString()))){
                        Toast.makeText(getApplicationContext(),"ENVIADO",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"CAMPO VACIO",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
