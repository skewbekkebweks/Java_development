package com.example.java_development;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button; int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = findViewById(R.id.go);
        button.setBackgroundColor(getResources().getColor(R.color.purple_700));

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.count += 1;
        System.out.println("resumed");
        this.button.setText("" + this.count);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.count += 2;
        System.out.println("paused");
        this.button.setText("" + this.count);
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("stopped");
    }

    public void action(View v) {

        EditText xEt = findViewById(R.id.x);
        String text = xEt.getText().toString();

        assert !text.isEmpty();

        int x = Integer.parseInt(text);
        Log.e("my errors", "text from input: " + text);

        TextView textView = findViewById(R.id.textView);
        textView.setText("" + division(x));
    }

    public int division(int x) {
        assert x != 0;
        return 100 / x;
    }

    public static int mult(int a, int b) {
        return a * b;
    }

    public static int sumArr(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }
}