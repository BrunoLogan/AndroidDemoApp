package com.example.androiddemoapp;

import com.example.androiddemoapp.model.Album;
import com.example.androiddemoapp.model.Photo;
import com.example.androiddemoapp.model.Post;
import com.example.androiddemoapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceholderAPI {

    @GET("photos/")
    Call<List<Photo>> photos();

    @GET("photos/")
    Call<List<Photo>> photos(@Query("albumId") int albumId);

    @GET("posts/")
    Call<List<Post>> posts();

    @GET("posts/{id}")
    Call<Post> post(@Path("id") int postId);

    @GET("albums/")
    Call<List<Album>> albums();

    @GET("albums/{id}")
    Call<Album> album(@Path("id") int albumId);

    @GET("users/")
    Call<List<User>> users();

    @GET("users/{id}")
    Call<User> user(@Path("id") int userId);

}
