package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Register_Activity extends AppCompatActivity {

    EditText edt_Username1,edt_Password2,edt_Password3;
    Button btn_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        anhXa();
        xuLyDangKy();

    }

    private void xuLyDangKy() {

    }

    private void anhXa() {

        edt_Username1 = findViewById(R.id.edt_Username1);
        edt_Password2 = findViewById(R.id.edt_Password2);
        edt_Password3 = findViewById(R.id.edt_Password3);

        btn_Register = findViewById(R.id.btn_Register);

    }
}