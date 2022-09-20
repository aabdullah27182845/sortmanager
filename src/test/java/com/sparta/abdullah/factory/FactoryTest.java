package com.sparta.abdullah.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    @DisplayName("Generate Array")
    void generateArray() {
        Factory factory = new Factory();
        int length = 50;
        int[] random = factory.generateArray(50);
        Assertions.assertEquals(50, random.length);
    }

    @Test
    @DisplayName("Boundary Test")
    void boundaryTest() {
        Factory factory = new Factory();
        int length = -1;
        int[] random = factory.generateArray(length);
        Assertions.assertArrayEquals(new int[] {}, random);
    }

}