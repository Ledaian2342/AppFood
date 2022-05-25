package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Splash_Activity extends AppCompatActivity {

    Button btn_Continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        getSupportActionBar().hide();

        btn_Continue = findViewById(R.id.btn_Continue);

        btn_Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(Splash_Activity.this,Login_Activity.class);
                startActivity(loginActivity);
            }
        });

    }
}