package com.example.java_development;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void action(View v) {
        EditText xEt = findViewById(R.id.x);
        String text = xEt.getText().toString();
        Log.e("my", "text from input is " + text);
        int x;

        if (!text.equals("")) {
            x = Integer.parseInt(text);
        } else {
            x = 1;
        }
        division(x);
    }

    public void division(int x) {
        int c = 1 / x;
        System.out.println(c);
    }
}