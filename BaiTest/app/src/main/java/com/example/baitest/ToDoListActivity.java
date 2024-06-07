package com.example.baitest;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitest.adapter.ToDoListAdapter;
import com.example.baitest.model.ToDoList;

import java.util.ArrayList;

/** @noinspection deprecation*/
public class ToDoListActivity extends AppCompatActivity {
    ImageView imageView;
    TextView tv_username;
    ListView lv_congviec;
    Button btnAdd;
    ToDoListAdapter toDoListAdapter;
    ArrayList<ToDoList> arrayList = new ArrayList<>();

    ToDoList selectedCV = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_to_do_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initWidgets();

        registerForContextMenu(lv_congviec);

        lv_congviec.setOnItemLongClickListener((parent, view, position, id) -> {
            selectedCV = toDoListAdapter.getItem(position);
            return false;
        });

        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(ToDoListActivity.this, AddActivity.class);
            startActivityForResult(intent, 1);
        });
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(ToDoListActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            assert data != null;
            String ten = data.getStringExtra("ten");
            String mota = data.getStringExtra("mota");
            String thoihan = data.getStringExtra("thoihan");
            arrayList.add(new ToDoList(ten, mota, thoihan));
            Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            toDoListAdapter.notifyDataSetChanged();
        }
        else {
            Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_xoa, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.actionXoa){
            AlertDialog.Builder builder = new AlertDialog.Builder(ToDoListActivity.this);
            builder.setTitle("Xác nhận");
            builder.setMessage("Bạn có chắc muốn xoá công việc này?");
            builder.setPositiveButton("Đồng ý", (dialog, id) -> toDoListAdapter.remove(selectedCV));
            builder.setNegativeButton("Huỷ", (dialog, id) -> dialog.dismiss());
            AlertDialog alert = builder.create();
            alert.show();
        }
        return super.onContextItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    private void initWidgets() {
        tv_username = findViewById(R.id.tv_username);
        tv_username.setText("Cậu Chính");
        imageView = findViewById(R.id.imgHinh);
        lv_congviec = findViewById(R.id.lv_congviec);
        btnAdd = findViewById(R.id.btnAdd);
        arrayList.add(new ToDoList("Tester", "Test game", "07/06 - 25/06"));
        arrayList.add(new ToDoList("BA", "Phân tích hệ thống", "07/06 - 25/06"));
        arrayList.add(new ToDoList("QC", "Lên kế hoạch kiểm thử", "07/06 - 25/06"));
        arrayList.add(new ToDoList("PM", "Điều phối, điều hành dự án", "07/06 - 25/06"));
        toDoListAdapter = new ToDoListAdapter(ToDoListActivity.this, R.layout.items_todols, arrayList);
        lv_congviec.setAdapter(toDoListAdapter);
    }
}