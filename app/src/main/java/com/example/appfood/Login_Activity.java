package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {

    EditText edt_Phonenumber,edt_Password;
    Button btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getActionBar().hide();

        anhXa();
        xuLyDangNhap();
    }

    private void xuLyDangNhap() {
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Phonemunber = edt_Password.getText().toString();
                String Password = edt_Password.getText().toString();

                if (Phonemunber.equals("admin") && Password.equals("admin"))
                {
                    Intent adminActivity = new Intent(Login_Activity.this, Admin_Activity.class);
                    startActivity(adminActivity);
                }

                else if (Phonemunber.equals("user") && Password.equals("user"))
                {
                    Intent homeActivity = new Intent(Login_Activity.this, Home_Activity.class);
                    startActivity(homeActivity);
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Kiểm tra lại",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void anhXa() {
        edt_Phonenumber = findViewById(R.id.edt_Phonenumber);
        edt_Password = findViewById(R.id.edt_Password2);

        btn_Login = findViewById(R.id.btn_Login);
    }
}