package com.sparta.abdullah.factory;

public class TimeCalculator {

    public static double calculateTime(long nanoTime) {
        if (nanoTime > 0) {
            double output =  nanoTime / 1000000000d;
            return output;
        } else {
            return -1;
        }

    }
}
