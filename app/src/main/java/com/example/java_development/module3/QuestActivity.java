package com.example.java_development.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        character = new Character(binding.editTextTextPersonName.getText().toString());
        story = new Story();

        show();


    }

    private void show() {
        binding.career.setText("K = " + character.K);
        binding.assets.setText("A = " + character.A + "");
        binding.reputation.setText("R = " + character.R + "");
        binding.text.setText(story.current_situation.text);
        binding.subject.setText(story.current_situation.subject);
        int count = story.current_situation.direction.length;
        binding.buttons.removeAllViews();
        binding.restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character = new Character(binding.editTextTextPersonName.getText().toString());
                story = new Story();
                show();

            }
        });
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
                        character.K += story.current_situation.dK;
                        character.A += story.current_situation.dA;
                        character.R += story.current_situation.dR;
                        show();
                    }
                });
            }
        } else {
            character.name = binding.editTextTextPersonName.getText().toString();
            TextView textView = new TextView(getBaseContext());
            textView.setText(character.name + " прошёл квест");
            binding.buttons.addView(textView);
        }
    }
}