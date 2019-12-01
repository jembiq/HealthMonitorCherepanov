package com.example.healthmonitor;

public class UserAccStorage {
    private static String fullName;
    private static int age;

    public static String getFullName() {
        return fullName;
    }

    public static void setFullName(String fullName) {
        UserAccStorage.fullName = fullName;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        UserAccStorage.age = age;
    }
}
