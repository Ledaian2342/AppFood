package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Register_Activity extends AppCompatActivity {

    TextView tv_haveAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        anhXa();
        xuLyDangKy();
    }

    private void xuLyDangKy() {
        tv_haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_Activity.this,Login_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        tv_haveAccount = findViewById(R.id.tv_haveAccount);
    }
}