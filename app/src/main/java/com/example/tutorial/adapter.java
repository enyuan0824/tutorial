package com.example.tutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
public class adapter extends BaseAdapter {
    Context context;
    String namelist[];
    String usernamelist[];
    String passlist[];
    int flags[];
    String name[];
    String username[];

    String pass[];

    LayoutInflater inflter;

   // public adapter(Context applicationContext, String[] name,String[] username,String[] pass, int[] flags) {
     //   this.context = context;
       // this.namelist = name;
        //this.usernamelist = username;
       // this.passlist = pass;
       // this.flags = flags;
       // inflter = (LayoutInflater.from(applicationContext));
    //}

    public adapter(Context applicationContext, String[] name,String[] username,String[] pass, int[] flags) {
        this.context = context;
        this.name = name;
        this.username = username;
        this.pass=pass;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {

        return namelist.length;

    }

    @Override
    public Object getItem(int i) {
        return null;
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_text, null); //where getting the contianer

        //ImageView icon = (ImageView) view.findViewById(R.id.icon);
        // icon.setImageResource(flags[i]);

       // TextView name = (TextView) view.findViewById(R.id.name);
      //  name.setText(namelist[i]);

        //TextView username = (TextView) view.findViewById(R.id.username);
        //username.setText(usernamelist[i]);

        //TextView password = (TextView) view.findViewById(R.id.password);
        //password.setText(passlist[i]);
        return view;
    }
}
