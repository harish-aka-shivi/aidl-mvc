// IAddService.aidl
package com.staqu.aidldemo;

// Declare any non-default types here with import statements

interface IAddServiceAidl {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);

    int add(in int ValueFirst, in int valueSecond);
}