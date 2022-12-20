package com.example.java_development;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.java_development.databinding.ActivityLesson01122022Binding;

public class Lesson01122022 extends AppCompatActivity {
    ActivityLesson01122022Binding binding;
    EditText eT1;
    EditText eT2;
    Button button;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson01122022);
        this.binding = ActivityLesson01122022Binding.inflate(getLayoutInflater());
        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
        button = findViewById(R.id.button);
        eT1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!(eT1.getText().toString().equals(eT2.getText().toString()))) {
                    eT2.setText(editable);
                }
            }
        });
        eT2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!(eT1.getText().toString().equals(eT2.getText().toString()))) {
                    eT1.setText(editable);
                }
            }
        });
        button.setOnClickListener(view -> {
            eT1.setText("");
        });

    }
}