package com.example.baitest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initWidgets();

        addControl();
    }

    private void addControl() {
        btnLogin.setOnClickListener(v -> {
            String email = edtEmail.getText().toString();
            String pw = edtPassword.getText().toString();
            if (email.equals("hrmcisolutions@mcisolutions.com.vn") && pw.equals("123")){
                Intent intent = new Intent(LoginActivity.this, ToDoListActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(LoginActivity.this, "Thông tin tài khoản không chính xác", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void initWidgets() {
        edtEmail = findViewById(R.id.etEmail);
        edtPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
}