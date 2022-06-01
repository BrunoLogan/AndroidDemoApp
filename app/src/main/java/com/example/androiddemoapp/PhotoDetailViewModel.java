package com.example.androiddemoapp;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androiddemoapp.model.Album;
import com.example.androiddemoapp.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDetailViewModel extends ViewModel {

    private static final String TAG = "PhotoDetailViewModel";

    private MutableLiveData<Album> mAlbum;
    private final Callback<Album> albumCallback = new Callback<Album>() {
        @Override
        public void onResponse(Call<Album> call, Response<Album> response) {
            if(response.isSuccessful()){
                mAlbum.setValue(response.body());
            }
        }

        @Override
        public void onFailure(Call<Album> call, Throwable t) {
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };

    private MutableLiveData<User> mUser;
    private final Callback<User> userCallback = new Callback<User>() {
        @Override
        public void onResponse(Call<User> call, Response<User> response) {
            if(response.isSuccessful()){
                mUser.setValue(response.body());
            }
        }

        @Override
        public void onFailure(Call<User> call, Throwable t) {
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };

    public PhotoDetailViewModel() {
    }

    public LiveData<Album> getAlbum(int albumId) {
        if(mAlbum == null) {
            mAlbum = new MutableLiveData<Album>();
            JSONPlaceholder jph = JSONPlaceholder.getInstance();
            if(jph != null) {
                jph.getAlbum(albumId, albumCallback);
            }
        }
        return mAlbum;
    }

    public LiveData<User> getUser(int userId){
        if(mUser == null) {
            mUser = new MutableLiveData<User>();
            JSONPlaceholder jph = JSONPlaceholder.getInstance();
            if(jph != null) {
                jph.getUser(userId, userCallback);
            }
        }
        return mUser;
    }


}
