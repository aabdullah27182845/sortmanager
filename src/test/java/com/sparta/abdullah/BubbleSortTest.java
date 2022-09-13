package com.sparta.abdullah;

import com.sparta.abdullah.sorters.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    static BubbleSort bs = new BubbleSort();

    @Test
    @DisplayName("Getter Test")
    void sortArrayTest() {
        long invalidTime = bs.getTimeTaken();
        Assertions.assertEquals(-1, invalidTime);
    }

    @Test
    @DisplayName("Regular Bubble Sort")
    void sortArrayTest2() {
        int[] arrayToBeTested = {54, 21, 32, 4, 20, 25, 28, 29, 11, 15};
        int[] sortedArray = {4, 11, 15, 20, 21, 25, 28, 29, 32, 54};
        assertArrayEquals(sortedArray, bs.sortArray(arrayToBeTested));
    }

    @Test
    @DisplayName("Getter Test")
    void sortArrayTest3() {
        long validTime = bs.getTimeTaken();
        long notTrueTime = -1;
        System.out.println(bs.getTimeTaken());
        Assertions.assertTrue(notTrueTime != validTime);
    }

}