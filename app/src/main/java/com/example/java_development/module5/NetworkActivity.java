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
import com.example.java_development.module5.helpers.MyCallback;
import com.example.java_development.module5.retro.RetroHelper;
import com.example.java_development.module5.retro.UserService;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NetworkActivity extends AppCompatActivity {
    LinearLayout layout;
    Button button;
    TextView textView;
    Button save;
    EditText email;
    EditText password;
    ListView usersLV;
    ArrayList<User> users = new ArrayList<>();
    ArrayAdapter a;
    Retrofit r;
    UserService s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        button = new Button(getBaseContext());
        textView = new TextView(getBaseContext());
        save = new Button(getBaseContext());
        email = new EditText(getBaseContext());
        password = new EditText(getBaseContext());
        usersLV = new ListView(getBaseContext());

        button.setText("Отправить запрос");
        textView.setHint("Тут ответ с сервера");
        save.setText("Создать пользователя");

        layout = findViewById(R.id.linear_layout);
        layout.addView(email);
        layout.addView(password);
        layout.addView(textView);
        layout.addView(button);
        layout.addView(save);
        layout.addView(usersLV);
        a = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, users);
        usersLV.setAdapter(a);

        button.setOnClickListener(view -> send());
        save.setOnClickListener(view -> save());

        r = RetroHelper.getServer();
        s = r.create(UserService.class);
    }

    public void save() {
        User user = new User(
                "Name" + Math.floor(Math.random() * 10),
                "Lastname" + Math.floor(Math.random() * 10),
                (int) Math.floor(Math.random() * 20)
        );
        Call<Void> call = s.saveUser(user);
        call.enqueue((MyCallback<Void>) (call1, response) -> {
            send();
        });
    }

    public void send() {
        Call<List<User>> call = s.users(email.getText().toString(), password.getText().toString());
        call.enqueue((MyCallback<List<User>>) (call1, response) -> {
            List<User> body = response.body();
            System.out.println(body);
            users.clear();
            users.addAll(body);
            a.notifyDataSetChanged();
        });
    }

//    class MyThread extends Thread {
//        @Override
//        public void run() {
//            HttpURLConnection connection = null;
//            try {
//                URL url = new URL("http://192.168.1.85:8080/?email=a@a.ru&pwd=123456");
//                connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("POST");
//                Scanner scanner = new Scanner(connection.getInputStream());
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText(scanner.nextLine());
//                    }
//                });
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            } finally {
//                if (connection != null) {
//                    connection.disconnect();
//                }
//            }
//        }
//    }
}