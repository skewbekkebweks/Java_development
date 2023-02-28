package com.example.java_development.module4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.java_development.R;

import java.util.ArrayList;

public class MyMonthAdapter extends ArrayAdapter<MyMonth> {
    public MyMonthAdapter(@NonNull Context context, ArrayList<MyMonth> data) {
        super(context, R.layout.mymonth_list_item, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mymonth_list_item, parent, false);
        }
        TextView month = convertView.findViewById(R.id.month);
        TextView temp = convertView.findViewById(R.id.temp);
        TextView days = convertView.findViewById(R.id.days);
        CheckBox like = convertView.findViewById(R.id.like);
        MyMonth item = getItem(position);
        month.setText(item.getMonth());
        temp.setText(item.getTemp() + "");
        days.setText(item.getDays() + "");
        if (item.isLike()) {
            convertView.setBackgroundColor(Color.MAGENTA);
        } else {
            convertView.setBackgroundColor(Color.WHITE);
        }
        like.setOnCheckedChangeListener(null);
        like.setChecked(item.isLike());

        View finalConvertView = convertView;
        like.setOnCheckedChangeListener((compoundButton, b) -> {
            item.setLike(b);
            System.out.println(getItem(position));
            System.out.println(b);
            System.out.println(item.isLike());
            if (b) {
                finalConvertView.setBackgroundColor(Color.MAGENTA);
            } else {
                finalConvertView.setBackgroundColor(Color.WHITE);
            }
        });
        return convertView;
    }
}
