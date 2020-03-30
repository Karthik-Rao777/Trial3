package com.e.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MoreScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_screen);


    }



    public void video(View view){
        Intent intent = new Intent(MoreScreen.this,Video.class);
        startActivity(intent);

    }

    public void weight(View view){
        Intent in = new Intent(MoreScreen.this,WeightActivity.class);
        startActivity(in);
    }



}
