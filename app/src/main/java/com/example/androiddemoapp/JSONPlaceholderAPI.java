package com.example.androiddemoapp;

import com.example.androiddemoapp.model.Photo;
import com.example.androiddemoapp.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONPlaceholderAPI {

    @GET("photos/")
    Call<List<Photo>> photos(@Query("albumId") int albumId);

    @GET("posts/")
    Call<List<Post>> posts();

}
