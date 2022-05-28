package com.example.appfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_Activity extends AppCompatActivity {

    TextView tv_haveAccount;
    EditText edt_RegEmail, edt_RegPassword, edt_RegAgPassword;
    Button btn_Register;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        initUi();
        initListener();


    }

    private void initUi() {
        tv_haveAccount = findViewById(R.id.tv_haveAccount);
        edt_RegEmail = findViewById(R.id.edt_RegEmail);
        edt_RegPassword = findViewById(R.id.edt_RegPassword);
        edt_RegAgPassword = findViewById(R.id.edt_RegAgPassword);
        btn_Register = findViewById(R.id.btn_Register);
        progressDialog = new ProgressDialog(this);

    }

    private void initListener() {
        tv_haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_Activity.this, Login_Activity.class);
                startActivity(intent);
            }
        });

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRegister();
            }
        });
    }

    private void onClickRegister() {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        progressDialog.show();
        progressDialog.setMessage("Đang Đăng Ký, Vui Lòng Chờ");
        String email = edt_RegEmail.getText().toString().trim();
        String password = edt_RegPassword.getText().toString().trim();
        String agpassword = edt_RegAgPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty() || agpassword.isEmpty())
        {
            progressDialog.dismiss();
            Toast.makeText(Register_Activity.this, "Nhập Đầy Đủ Thông Tin",
                    Toast.LENGTH_SHORT).show();
        }

        else if (!password.equals(agpassword))
        {
            progressDialog.dismiss();
            Toast.makeText(Register_Activity.this, "Mật Khẩu Không Giống Nhau",
                    Toast.LENGTH_SHORT).show();
        }

        else
        {
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                progressDialog.dismiss();
                                Toast.makeText(Register_Activity.this, "Đăng Ký Thành Công, Vui Lòng Đăng Nhập",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register_Activity.this, Login_Activity.class);
                                startActivity(intent);
                                finishAffinity();
                            } else {
                                // If sign in fails, display a message to the user.
                                progressDialog.dismiss();
                                Toast.makeText(Register_Activity.this, "Đăng Ký Không Thành Công, Kiểm Tra Lại Email hoặc Mật Khẩu",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }

    }

}