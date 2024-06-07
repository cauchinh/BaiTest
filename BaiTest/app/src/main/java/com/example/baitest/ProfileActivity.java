package com.example.baitest;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitest.model.Profile;


public class ProfileActivity extends AppCompatActivity {
    ImageView imageView;
    TextView tvDisplayname, tvEmail;
    Button btnLogout;
    Profile profile;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initWidgets();

        if (profile != null) {
            imageView.setImageResource(profile.getHinh());
            tvDisplayname.setText("Tên người dùng: " + profile.getUsername());
            tvEmail.setText("Email: " + profile.getEmail());
        }
        btnLogout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
            builder.setTitle("Xác nhận");
            builder.setMessage("Bạn có chắc muốn đăng xuất không?");
            builder.setPositiveButton("Đồng ý", (dialog, id) -> {
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
            });
            builder.setNegativeButton("Huỷ", (dialog, id) -> dialog.dismiss());
            AlertDialog alert = builder.create();
            alert.show();
        });
    }

    private void initWidgets() {
        imageView = findViewById(R.id.imgAvt);
        tvDisplayname = findViewById(R.id.tv_displayname);
        tvEmail = findViewById(R.id.tv_email);
        btnLogout = findViewById(R.id.btnLogout);
        profile = new Profile("Cậu Chính", "hrmcisolutions@mcisolutions.com.vn", R.drawable.abc);
    }
}