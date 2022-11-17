package com.example.java_development;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LessonActivity extends AppCompatActivity {
    Button button2;
    Button button3;
    Button button4;
    TextView textView2;
    EditText editTextTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        textView2 = findViewById(R.id.textView2);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        View.OnClickListener listener = this::action;
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        textView2.setOnClickListener(listener);
        editTextTextPassword.setOnClickListener(listener);
    }

    public void action(View v) {
        switch (v.getId()) {
            case R.id.button2:
                Toast.makeText(this, "Кнопка 2", Toast.LENGTH_SHORT).show();
                String x = button2.getText().toString();
                button2.setText(new StringBuilder(x).reverse().toString());
                break;
            case R.id.button3:
                x = new StringBuilder(((int) (Math.random() * 5)) + "").toString();
                button3.setText(x);
                System.out.println(x);
                button3.setBackgroundColor(getResources().getColor(R.color.purple_200));
                break;
            case R.id.button4:
                button4.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.textView2:
                textView2.setVisibility(View.INVISIBLE);
                break;
            case R.id.editTextTextPassword:
                x = editTextTextPassword.getText().toString();
                editTextTextPassword.setText(new StringBuilder(x).append(1).reverse().toString());
                break;
            default:
                System.out.println("...");
        }
    }
}