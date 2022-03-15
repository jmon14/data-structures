package com.jamonra;

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
        System.out.println(getDurationString(4500));
    }

    private static String getDurationString(int min, int sec) {
        if (min < 0 || sec < 0 || sec > 59) {
            return INVALID_VALUE_MESSAGE;
        }
        int hr = min / 60;
        min = min % 60;

        String minString = checkZero(min);
        String secString = checkZero(sec);
        String hrString = checkZero(hr);

        return String.format("%sh %sm %ss", hrString, minString, secString);
    }

    private static String getDurationString(int sec) {
        if (sec < 0) {
            return INVALID_VALUE_MESSAGE;
        }
        int min = sec / 60;
        sec = sec % 60;
        return getDurationString(min, sec);
    }

    private static String checkZero(int time) {
        return time < 10 ? "0" + time : Integer.toString(time);
    }
}
