package com.sparta.abdullah.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCalculatorTest {

    @Test
    @DisplayName("Functional Test")
    void getCalculated() {
        long testValue = 300000000000L;
        Assertions.assertEquals(300.0D, TimeCalculator.calculateTime(testValue));
    }

    @Test
    @DisplayName("Boundary Test")
    void boundaryCalculated() {
        long testValue = -34344L;
        Assertions.assertEquals(-1D, TimeCalculator.calculateTime(testValue));
    }

}