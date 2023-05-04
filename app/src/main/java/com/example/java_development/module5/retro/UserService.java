package com.example.java_development.module5.retro;

import com.example.java_development.module5.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserService {

    @POST("/user")
    @FormUrlEncoded
    public Call<List<User>> users(@Field("email") String email, @Field("pwd") String password);

    @PUT("/user")
    public Call<Void> saveUser(@Body User user);
}
