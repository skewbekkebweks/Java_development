package com.example.java_development;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

public class LessonActivity24112022 extends AppCompatActivity {
    EditText nEt;
    Button go;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson24112022);
        this.nEt = findViewById(R.id.num);
        this.go = findViewById(R.id.go);
        this.textView = findViewById(R.id.showNum);
//        View.OnClickListener listener = this::action;
        go.setOnClickListener(this::action);
    }

    public void action(View v) {
        String text = this.nEt.getText().toString();
        if (text.equals("")) {
            text = "0";
        }
        int x = Integer.parseInt(text + "");

        this.nEt.setText("");

        int y = Integer.parseInt(this.textView.getText().toString());
        this.textView.setText(x + y + "");
    }
}