package com.example.appfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity {

    EditText edt_LogEmail, edt_LogPassword;
    TextView tv_notAccount;
    Button btn_Login;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        initUi();
        initListener();
    }

    private void initUi() {
        edt_LogEmail = findViewById(R.id.edt_LogEmail);
        edt_LogPassword = findViewById(R.id.edt_LogPassword);
        tv_notAccount = findViewById(R.id.tv_notAccount);
        btn_Login  = findViewById(R.id.btn_Login);
        progressDialog = new ProgressDialog(this);

    }

    private void initListener() {

        tv_notAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this,Register_Activity.class);
                startActivity(intent);
            }
        });

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickLogin();
            }
        });
    }

    private void onClickLogin() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        progressDialog.show();
        progressDialog.setMessage("Đang Đăng Nhập, Vui Lòng Chờ");

        String email = edt_LogEmail.getText().toString().trim();
        String password = edt_LogPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty())
        {
            progressDialog.dismiss();
            Toast.makeText(Login_Activity.this, "Nhập Đầy Đủ Thông Tin",
                    Toast.LENGTH_LONG).show();
        }

        else
        {
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                progressDialog.dismiss();
                                Toast.makeText(Login_Activity.this, "Đăng Nhập Thành Công",
                                        Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Login_Activity.this, Home_Activity.class);
                                startActivity(intent);
                                finishAffinity();
                            } else {
                                // If sign in fails, display a message to the user.
                                progressDialog.dismiss();
                                Toast.makeText(Login_Activity.this, "Đăng Nhập Không Thành Công, Kiểm Tra Lại Email hoặc Mật Khẩu",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }

    }

}