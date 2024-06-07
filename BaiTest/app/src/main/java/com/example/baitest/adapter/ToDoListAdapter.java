package com.example.baitest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.baitest.R;
import com.example.baitest.model.ToDoList;

import java.util.List;

public class ToDoListAdapter extends ArrayAdapter<ToDoList> {
    public ToDoListAdapter(@NonNull Context context, int resource, @NonNull List<ToDoList> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.items_todols, null);
        }
        ToDoList tdl = getItem(position);
        if (tdl != null){
            TextView tvTen = (TextView) view.findViewById(R.id.tv_tencv);
            TextView tvMota = (TextView) view.findViewById(R.id.tv_mota);
            TextView tvThoihan = (TextView) view.findViewById(R.id.tv_thoihan);
            tvTen.setText(tdl.getTenCv());
            tvMota.setText("Mô tả: " + tdl.getMota());
            tvThoihan.setText("Thời hạn: " + tdl.getThoihan());
        }
        return view;
    }
}
