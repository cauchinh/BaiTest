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


public class AddActivity extends AppCompatActivity {
    EditText edtTen, edtMota, edtThoihan;
    Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initWidgets();
        btnThem.setOnClickListener(v -> {
            String ten = edtTen.getText().toString();
            String mota = edtMota.getText().toString();
            String thoihan = edtThoihan.getText().toString();
            if (ten.isEmpty() || mota.isEmpty() || thoihan.isEmpty()){
                Toast.makeText(AddActivity.this, "Vui lòng điền đủ thông tin", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("ten", ten);
                resultIntent.putExtra("mota", mota);
                resultIntent.putExtra("thoihan", thoihan);
                setResult(RESULT_OK, resultIntent);
                finish();
            }


        });
    }

    private void initWidgets() {
        edtTen =  findViewById(R.id.edtTen);
        edtMota = findViewById(R.id.edtMota);
        edtThoihan = findViewById(R.id.edtThoihan);
        btnThem = findViewById(R.id.btnThem);
    }
}