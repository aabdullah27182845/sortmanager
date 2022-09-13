package com.sparta.abdullah.sorters;

public class Merger {

    public static int[] mergeArrays(int[] array1, int[] array2) {
        int listLength = array1.length + array2.length;
        int[] outputList = new int[listLength];

        int array1Counter = 0;
        int array2Counter = 0;
        for (int i = 0; i < outputList.length; i++) {

            if (array1.length == array1Counter) {
                for (int j = i; j < outputList.length; j++) {
                    outputList[j] = array2[array2Counter];
                }
                return outputList;
            }

            if (array2.length == array2Counter) {
                for (int j = i; j < outputList.length; j++) {
                    outputList[j] = array1[array1Counter];
                }
                return outputList;
            }

            if (array1[array1Counter] < array2[array2Counter]) {
                outputList[i] = array1[array1Counter++];

            } else if (array1[array1Counter] > array2[array2Counter]) {
                outputList[i] = array2[array2Counter++];
            } else if (array1[array1Counter] == array2[array2Counter]) {
                outputList[i] = array1[array1Counter];
                array1Counter += 1;
            }
        }
        return outputList;
    }
}
