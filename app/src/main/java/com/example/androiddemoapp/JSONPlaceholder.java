package com.example.androiddemoapp;

import com.example.androiddemoapp.model.Photo;
import com.example.androiddemoapp.model.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JSONPlaceholder {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final String TAG = "JSONPlaceholder";

    private JSONPlaceholderAPI jsonplacholderAPI;

    public JSONPlaceholder() {

    }

    public void start() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        this.jsonplacholderAPI = retrofit.create(JSONPlaceholderAPI.class);
    }

    void getPhotos(int albumId, Callback<List<Photo>> callback) {
        Call<List<Photo>> call = this.jsonplacholderAPI.photos(albumId);
        call.enqueue(callback);
    }

    void getPosts(Callback<List<Post>> callback) {
        Call<List<Post>> call = this.jsonplacholderAPI.posts();
        call.enqueue(callback);
    }
}
