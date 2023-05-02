package com.example.java_development.module5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.java_development.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkActivity extends AppCompatActivity {
    LinearLayout layout;
    Button button;
    TextView textView;
    EditText email;
    EditText password;
    ListView usersLV;
    ArrayList<User> users = new ArrayList<>();
    ArrayAdapter a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        button = new Button(getBaseContext());
        textView = new TextView(getBaseContext());
        email = new EditText(getBaseContext());
        password = new EditText(getBaseContext());
        usersLV = new ListView(getBaseContext());

        button.setText("Отправить запрос");
        textView.setHint("Тут ответ с сервера");

        layout = findViewById(R.id.linear_layout);
        layout.addView(email);
        layout.addView(password);
        layout.addView(textView);
        layout.addView(button);
        layout.addView(usersLV);
        a = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, users);
        usersLV.setAdapter(a);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });
    }

    public void send() {
//        (new MyThread()).start();
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("email", email.getText().toString())
                .add("pwd", password.getText().toString())
                .build();
        Request request = new Request.Builder()
                .url("http:192.168.1.85:8080/user")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                int code = response.code();
                String body = response.body().string();
                if (code < 300) {
                    runOnUiThread(() -> {
                        Gson gson = new Gson();
                        User[] user = gson.fromJson(body, User[].class);
                        textView.setText(body);
                        users.clear();
                        users.addAll(Arrays.asList(user));
                    });
                } else {
                    runOnUiThread(() -> {
                        textView.setText("Произошла ошибка");
                    });
                }
            }
        });
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            HttpURLConnection connection = null;
            try {
                URL url = new URL("http://192.168.1.85:8080/?email=a@a.ru&pwd=123456");
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                Scanner scanner = new Scanner(connection.getInputStream());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(scanner.nextLine());
                    }
                });

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }
    }
}