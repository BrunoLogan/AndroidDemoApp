package com.example.androiddemoapp.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androiddemoapp.NativeLib;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        NativeLib lib = new NativeLib();
//        mText.setValue("This is dashboard fragment");
        mText.setValue(lib.stringFromJNI());

    }

    public LiveData<String> getText() {
        return mText;
    }
}