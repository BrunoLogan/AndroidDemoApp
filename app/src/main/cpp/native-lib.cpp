//
// Created by logan on 01/06/2022.
//

#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_androiddemoapp_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_androiddemoapp_NativeLib_anotherTest(JNIEnv *env, jobject thiz) {
    std::string test = "Another Test!";
    return env->NewStringUTF(test.c_str());
}