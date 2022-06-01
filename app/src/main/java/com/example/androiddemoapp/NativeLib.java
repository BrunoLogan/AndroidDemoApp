package com.example.androiddemoapp;

public class NativeLib {
    static {
        System.loadLibrary("native-lib");
    }

    public NativeLib() {

    }

    public native String stringFromJNI();

    public native String anotherTest();
}
