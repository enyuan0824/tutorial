package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name,username,pass,com_pass;
    Button veriify,reset;
    String n,user_n,p,cp;

    private dbmanager personal_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verify(View view) {
        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        pass=findViewById(R.id.pass);
        com_pass=findViewById(R.id.comfirm_password);
        veriify=findViewById(R.id.button3);

        n = name.getText().toString();
        user_n = username.getText().toString();
        p = pass.getText().toString();
        cp = com_pass.getText().toString();

        if (name.getText().toString().isEmpty() || username.getText().toString().isEmpty() ||
            pass.getText().toString().isEmpty() || com_pass.getText().toString().isEmpty()) {
            Toast.makeText(this,"That cant no be empty!",Toast.LENGTH_SHORT).show();
        }else if (p.equals(cp)){
            personal_details = new dbmanager(this);

            personal_details.open();
            personal_details.insert(n,user_n,p);
            personal_details.close();

            Intent intent = new Intent(this, list.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"The password is not same.",Toast.LENGTH_SHORT).show();
        }
    }
    public void reset(View view) {
        reset=findViewById(R.id.button4);
        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        pass=findViewById(R.id.pass);
        com_pass=findViewById(R.id.comfirm_password);

        name.setText("");
        username.setText("");
        pass.setText("");
        com_pass.setText("");
    }
}