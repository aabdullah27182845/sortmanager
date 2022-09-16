package com.sparta.abdullah.sorters;

import com.sparta.abdullah.sorters.MergeSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    @DisplayName("Merge Sort Test")
    void test() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort ms = new MergeSort();
        int[] sorted = ms.sortArray(actual);
        assertArrayEquals(expected, actual);
    }

}