package com.example.androiddemoapp.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androiddemoapp.JSONPlaceholder;
import com.example.androiddemoapp.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private static final String TAG = "HomeViewModel";
    private MutableLiveData<List<Photo>> mPhotos;
    private final Callback<List<Photo>> photoListCallback = new Callback<List<Photo>>() {
        @Override
        public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
            if (response.isSuccessful()) {
                mPhotos.setValue(response.body());
            }
        }

        @Override
        public void onFailure(Call<List<Photo>> call, Throwable t) {
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };


    public HomeViewModel() {
    }

    public LiveData<List<Photo>> getPhotos() {
        if (mPhotos == null) {
            mPhotos = new MutableLiveData<List<Photo>>();
            loadPhotos();
        }
        return mPhotos;
    }

    private void loadPhotos() {
        JSONPlaceholder jph = JSONPlaceholder.getInstance();
        if (jph != null) {
            jph.getPhotos(1, photoListCallback);
        }
    }
}