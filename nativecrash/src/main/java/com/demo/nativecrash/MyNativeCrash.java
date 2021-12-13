package com.demo.nativecrash;

public class MyNativeCrash {

    static {
        System.loadLibrary("myNativeCrash");
    }

    public native void nullPointer();
}
