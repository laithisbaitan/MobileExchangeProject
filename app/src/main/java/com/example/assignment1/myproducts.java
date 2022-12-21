package com.example.assignment1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class myproducts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Product");
        setContentView(R.layout.activity_myproducts);
    }
}