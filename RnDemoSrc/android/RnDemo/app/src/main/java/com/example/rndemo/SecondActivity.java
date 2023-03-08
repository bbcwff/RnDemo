package com.example.rndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String params = intent.getStringExtra("params");
        Toast.makeText(this, "从react-native中传递过来的数据" + params, Toast.LENGTH_LONG).show();

    }
}