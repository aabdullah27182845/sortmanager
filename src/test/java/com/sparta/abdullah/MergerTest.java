package com.sparta.abdullah;

import com.sparta.abdullah.sorters.BubbleSort;
import com.sparta.abdullah.sorters.Merger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergerTest {

    BubbleSort bs = new BubbleSort();

    @Test
    @DisplayName("Function Test")
    void mergerTest1() {
        int[] array1 = {55, 11, 23, 24, 27, 35};
        int[] array2 = {35, 23, 11, 40};
        array1 = bs.sortArray(array1);
        array2 = bs.sortArray(array2);

        int[] finalArray = Merger.mergeArrays(array1, array2);
        assertArrayEquals(new int[] {11, 11, 23, 23, 24, 27, 35, 35, 40, 55} , finalArray);

    }

}