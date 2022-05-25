package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {

    EditText edt_Phonenumber, edt_Password;
    TextView tv_notAccount;
    Button btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        anhXa();
        xuLyDangNhap();

    }

    private void xuLyDangNhap() {

        tv_notAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Login_Activity.this,Register_Activity.class);
                startActivity(intent);
            }
        });


        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Phonenumber = edt_Phonenumber.getText().toString();
                String Password = edt_Password.getText().toString();

                if (Phonenumber.equals("admin") && Password.equals("admin"))
                {
                    Intent intent =  new Intent(Login_Activity.this,Admin_Activity.class);
                    startActivity(intent);
                }

                else if (Phonenumber.equals("user") && Password.equals("user"))
                {
                    Intent intent =  new Intent(Login_Activity.this,Home_Activity.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(getApplicationContext(),"Nhập admin hoặc user",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void anhXa() {

        edt_Phonenumber = findViewById(R.id.edt_Phonenumber);
        edt_Password = findViewById(R.id.edt_Password);

        tv_notAccount = findViewById(R.id.tv_notAccount);

        btn_Login = findViewById(R.id.btn_Login);
    }
}