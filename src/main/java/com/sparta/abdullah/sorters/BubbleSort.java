package com.sparta.abdullah.sorters;

public class BubbleSort implements Sorter {

    private long timeTaken;

    @Override
    public int[] sortArray(int[] arrayToSort) {
        boolean flag = true;
        int rounds = 0;

        long timeStart = System.nanoTime();

        while (flag) {
            flag = false;
            for (int i = 0; i < arrayToSort.length - 1 - rounds; i++) {
                if (arrayToSort[i] > arrayToSort[i+1]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i+1];
                    arrayToSort[i+1] = temp;
                    flag = true;
                }
            }
            rounds++;
        }

        long timeEnd = System.nanoTime();
        this.timeTaken = timeEnd - timeStart;
        return arrayToSort;
    }

    public long getTimeTaken() {
        if ( (int) (timeTaken) == 0) {
            return -1;   // -1 is a marker for invalid use of the getter function
        }
        return timeTaken;
    }
}
