package com.example.java_development.module4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.java_development.databinding.ActivityMapBinding;

public class MapActivity extends AppCompatActivity {
    ActivityMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.save.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(binding.editTextStr.getText().toString(), Integer.parseInt(binding.editTextNum.getText().toString()));
            editor.apply();
        });

        binding.load.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            Integer num = sharedPreferences.getInt(binding.editTextStr.getText().toString(), 0);
            binding.editTextNum.setText(num.toString());
        });
    }


}