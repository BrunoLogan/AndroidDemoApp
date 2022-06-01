package com.example.androiddemoapp;

import android.util.Log;

import com.example.androiddemoapp.model.Album;
import com.example.androiddemoapp.model.Photo;
import com.example.androiddemoapp.model.Post;
import com.example.androiddemoapp.model.User;
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

    private JSONPlaceholderAPI jsonPlaceholderAPI;

    private static JSONPlaceholder instance;

    private JSONPlaceholder() {

    }

    public static JSONPlaceholder getInstance() {
        if (instance == null) {
            instance = new JSONPlaceholder();
            instance.start();
        }

        return instance;
    }

    private void start() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        this.jsonPlaceholderAPI = retrofit.create(JSONPlaceholderAPI.class);
    }

    public void getPhotos(Callback<List<Photo>> callback) {
        Call<List<Photo>> call = this.jsonPlaceholderAPI.photos();
        call.enqueue(callback);
    }

    public void getPhotos(int albumId, Callback<List<Photo>> callback) {
        Call<List<Photo>> call = this.jsonPlaceholderAPI.photos(albumId);
        Log.d(TAG, "getPhotos: " + call.request().url().toString());
        call.enqueue(callback);
    }

    public void getPosts(Callback<List<Post>> callback) {
        Call<List<Post>> call = this.jsonPlaceholderAPI.posts();
        call.enqueue(callback);
    }

    public void getPost(int postId, Callback<Post> callback) {
        Call<Post> call = this.jsonPlaceholderAPI.post(postId);
        call.enqueue(callback);
    }

    public void getAlbums(Callback<List<Album>> callback) {
        Call<List<Album>> call = this.jsonPlaceholderAPI.albums();
        call.enqueue(callback);
    }

    public void getAlbum(int albumId, Callback<Album> callback) {
        Call<Album> call = this.jsonPlaceholderAPI.album(albumId);
        Log.d(TAG, "getAlbum: " + call.request().url().toString());
        call.enqueue(callback);
    }

    public void getUsers(Callback<List<User>> callback) {
        Call<List<User>> call = this.jsonPlaceholderAPI.users();
        call.enqueue(callback);
    }

    public void getUser(int userId, Callback<User> callback) {
        Call<User> call = this.jsonPlaceholderAPI.user(userId);
        Log.d(TAG, "getUser: " + call.request().url().toString());
        call.enqueue(callback);
    }

}
