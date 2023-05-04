package com.example.java_development.module5.retro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroHelper { // Singleton - единственный экземпляр
    private static Retrofit instance = null;
    private RetroHelper() {}

    public static Retrofit getServer() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl("http://192.168.1.85:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
