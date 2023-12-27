package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class list extends AppCompatActivity {

    String un,n,p;
    private dbmanager personal_details;
    private dbhelper dbh;
    final String[] from = new String[] {dbhelper._ID,dbhelper.NAME,dbhelper.USERNAME,dbhelper.PASS};

    final int[] to = new int[] { R.id.username,R.id.name, R.id.username, R.id.password };

    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();


        personal_details = new dbmanager(this);
        personal_details.open();
        Cursor cursor = personal_details.fetch();
        ListView simpleList = (ListView) findViewById(R.id.listview);
        //simpleList.setEmptyView(findViewById(R.id.));

       adapter = new SimpleCursorAdapter(this, R.layout.activity_list, cursor, from, to, 0);
      adapter.notifyDataSetChanged();

        simpleList.setAdapter(adapter);
        //n = intent.getStringExtra("1");
        //un = intent.getStringExtra("2");
        //p = intent.getStringExtra("3");
        /*
        personal_details = new dbmanager(this);

        personal_details.open();
        personal_details.fetch();
        ArrayList namelist= new ArrayList();
        namelist.add(n);

        ArrayList usernamelist= new ArrayList();
        namelist.add(un);

        ArrayList passlist= new ArrayList();
        namelist.add(p);

        ListView simpleList = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.activity_text, R.id.name, namelist);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.activity_text, R.id.username, usernamelist);
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this, R.layout.activity_text, R.id.pass, passlist);
        simpleList.setAdapter(arrayAdapter1);
        simpleList.setAdapter(arrayAdapter2);
        simpleList.setAdapter(arrayAdapter3);

         */
    }
}