package com.example.empty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class login extends AppCompatActivity {

    private EditText login, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        pw = findViewById(R.id.password);
    }

    public void enter(View view){
        String name = login.getText().toString();
        String password = pw.getText().toString();

        Context context = getApplicationContext();
        CharSequence msg;
        int duration = Toast.LENGTH_SHORT;

        if (name.equals("password")) {
            if(password.equals("login")){
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
            }
            else {
                msg = "Wrong password.";
                Toast.makeText(context, msg, duration).show();
            }
        }
        else {
            msg = "Wrong login.";
            Toast.makeText(context, msg, duration).show();
        }
    }

}