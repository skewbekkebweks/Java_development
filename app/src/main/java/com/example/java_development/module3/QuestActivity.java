package com.example.java_development.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.java_development.databinding.ActivityQuestBinding;

public class QuestActivity extends AppCompatActivity {
    private Story story;
    private Character character;
    ActivityQuestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityQuestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        story = new Story();
        show();


    }

    private void show() {

        binding.text.setText(story.current_situation.text);
        binding.subject.setText(story.current_situation.subject);
        int count = story.current_situation.direction.length;
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                Button b = new Button(getBaseContext());
                final int a = i + 1;
                b.setText(a + "");
                binding.buttons.addView(b);

                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        story.go(a);
                        show();
                    }
                });
            }
        }
    }
}