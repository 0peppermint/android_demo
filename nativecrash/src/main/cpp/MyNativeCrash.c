
#include <android/log.h>
#include <assert.h>
#include <jni.h>
#include <string.h>
#include <stdint.h>
#include <stdbool.h>
#include <signal.h>



__attribute__((visibility("default"))) __attribute__((used))

void nullPointer(JNIEnv *jniEnv) {
    int *p = NULL;
    *p = 123;
}

JNIEXPORT void JNICALL Java_com_demo_nativecrash_MyNativeCrash_nullPointer(JNIEnv *env, jclass clazz) {
    nullPointer(env);
}