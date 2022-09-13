package com.sparta.abdullah.sorters;

public class MergeSort implements Sorter {

    private long timeTaken;

    public void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public void mergeSort(int[] inputList, int listLength) {
        if (listLength < 2) {
            return;
        }
        int mid = listLength / 2;
        int[] left = new int[mid];
        int[] right = new int[listLength - mid];

        System.arraycopy(inputList, 0, left, 0, mid);
        if (listLength - mid >= 0) System.arraycopy(inputList, mid, right, mid - mid, listLength - mid);
        mergeSort(left, mid);
        mergeSort(right, listLength - mid);

        merge(inputList, left, right, mid, listLength - mid);
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        long startTime = System.nanoTime();
        mergeSort(arrayToSort, arrayToSort.length);
        long endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        return arrayToSort;
    }

    public long getTimeTaken() {
        return timeTaken;
    }
}
