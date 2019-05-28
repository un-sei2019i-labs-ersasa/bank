package com.example.testfinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button ingresar;
    AdminSQLite helper= new AdminSQLite(this,"Base", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ingresar=(Button)findViewById(R.id.ingresar);
        ingresar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText identificacion=(EditText)findViewById(R.id.id_txt);
                EditText password=(EditText)findViewById(R.id.pass_txt);
                 Cursor cursor= helper.validadInformacion(Integer.valueOf(identificacion.toString()),Integer.valueOf(password.toString()));
                 if(cursor.getCount()>0){
                     Toast.makeText(getApplicationContext(),"SATISFACTORIO", Toast.LENGTH_LONG).show();
                 }
                 else{
                     Toast.makeText(getApplicationContext(),"USUARIO O CONTRASENIA INCORRECTOS", Toast.LENGTH_LONG).show();
                 }
                 identificacion.setText("");
                 password.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
