package com.example.java_development.module4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.java_development.R;

import java.util.ArrayList;
import java.util.Collections;

public class ListActivity extends AppCompatActivity {
    ListView mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mylist = findViewById(R.id.mylist);

        MyMonthAdapter adapter = new MyMonthAdapter(
                getBaseContext(),
                makeList()
        );

        mylist.setAdapter(adapter);
        mylist.setOnItemClickListener((adapterView, view, position, id) -> {
            Toast.makeText(getBaseContext(), adapter.getItem(position).toString(), Toast.LENGTH_LONG).show();
        });
    }

    public ArrayList<MyMonth> makeList() {
        ArrayList<MyMonth> monthsList = new ArrayList<>();

        monthsList.add(new MyMonth("January", -15, 31));
        monthsList.add(new MyMonth("February", -10, 28));
        monthsList.add(new MyMonth("March", -5, 31));
        monthsList.add(new MyMonth("April", 0, 30));
        monthsList.add(new MyMonth("May", 15, 31));
        monthsList.add(new MyMonth("June", 20, 30));
        monthsList.add(new MyMonth("July", 20, 31));
        monthsList.add(new MyMonth("August", 20, 31));
        monthsList.add(new MyMonth("September", 10, 30));
        monthsList.add(new MyMonth("October", 5, 31));
        monthsList.add(new MyMonth("November", 0, 30));
        monthsList.add(new MyMonth("December", -15, 31));

        return monthsList;
    }
}