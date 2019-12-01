package com.example.healthmonitor;

public class PressStorage {
    private static int sys;
    private static int dia;
    private static int pulse;
    private static boolean tachycardia;
    private static String date;

    public static int getSys() {
        return sys;
    }

    public static void setSys(int sys) {
        PressStorage.sys = sys;
    }

    public static int getDia() {
        return dia;
    }

    public static void setDia(int dia) {
        PressStorage.dia = dia;
    }

    public static int getPulse() {
        return pulse;
    }

    public static void setPulse(int pulse) {
        PressStorage.pulse = pulse;
    }

    public static boolean isTachycardia() {
        return tachycardia;
    }

    public static void setTachycardia(boolean tachycardia) {
        PressStorage.tachycardia = tachycardia;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        PressStorage.date = date;
    }
}