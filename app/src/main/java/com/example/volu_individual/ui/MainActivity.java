package com.example.volu_individual.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.volu_individual.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}