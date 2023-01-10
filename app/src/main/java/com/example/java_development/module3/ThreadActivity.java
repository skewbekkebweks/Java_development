package com.example.java_development.module3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.java_development.R;

import java.security.cert.CertPathBuilderSpi;

public class ThreadActivity extends AppCompatActivity {
    Button run, start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        run = findViewById(R.id.run);
        start = findViewById(R.id.start);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data data = new Data.Builder()
                        .putString("p1", "Привет всем").build();
                OneTimeWorkRequest r = new OneTimeWorkRequest.Builder(MyWorker.class)
                        .setInputData(data)
                        .build();
                WorkManager.getInstance().enqueue(r);
                WorkManager.getInstance().getWorkInfoByIdLiveData(r.getId())
                        .observe(ThreadActivity.this, new Observer<WorkInfo>() {
                            @Override
                            public void onChanged(WorkInfo workInfo) {
                                if (workInfo != null) System.out.println(workInfo.getOutputData().getString("r1"));
                            }
                        });
            }
        });
    }
}