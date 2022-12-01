package com.example.java_development;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.java_development.databinding.ActivityLessonBinding;

public class LessonActivity extends AppCompatActivity {
    ActivityLessonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        binding = ActivityLessonBinding.inflate(getLayoutInflater());
        View.OnClickListener listener = this::action;
        binding.button2.setOnClickListener(listener);
        binding.button3.setOnClickListener(listener);
        binding.button4.setOnClickListener(listener);
        binding.textView2.setOnClickListener(listener);
        binding.editTextTextPassword.setOnClickListener(listener);
    }

    public void action(View v) {
        switch (v.getId()) {
            case R.id.button2:
                Toast.makeText(this, "Кнопка 2", Toast.LENGTH_SHORT).show();
                String x = binding.button2.getText().toString();
                binding.button2.setText(new StringBuilder(x).reverse().toString());
                break;
            case R.id.button3:
                x = new StringBuilder(((int) (Math.random() * 5)) + "").toString();
                binding.button3.setText(x);
                System.out.println(x);
                binding.button3.setBackgroundColor(getResources().getColor(R.color.purple_200));
                break;
            case R.id.button4:
                binding.button4.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.textView2:
                binding.textView2.setVisibility(View.INVISIBLE);
                break;
            case R.id.editTextTextPassword:
                x = binding.editTextTextPassword.getText().toString();
                binding.editTextTextPassword.setText(new StringBuilder(x).append(1).reverse().toString());
                break;
            default:
                System.out.println("...");
        }
    }
}