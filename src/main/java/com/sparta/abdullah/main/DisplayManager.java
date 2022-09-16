package com.sparta.abdullah.main;

import java.util.Arrays;

public class DisplayManager {

    public void starter() {
        System.out.println("========== SORT MANAGER ==========");
        System.out.println("In the first input line, enter the \nlength of the list you'd like to make");
        System.out.println("In the second line, enter which \nsorting algorithm you'd like to use.");
    }

    public void listInputDisplay() {
        System.out.println("Enter a number that is higher than 1: ");
    }

    public void multipleChoiceDisplay() {
        System.out.println("Enter either (y) or (n) if you want to compare different sorting algorithms:");
    }

    public void sortInputDisplay() {
        System.out.println("Enter (m) for merge sort, (b) for bubble sort,\nand (t) for tree sort.");
    }

    public void displayUnsortedList(int[] list) {
        System.out.println("Here is the unsorted list: ");
        System.out.println(Arrays.toString(list) + "\n");
    }

    public void displaySortedList(int[] list) {
        System.out.println("Here is the sorted list: ");
        System.out.println(Arrays.toString(list) + "\n");
    }

    public void displaySortedList(int[] list, String choice) {
        System.out.println("Here is the sorted list for " + choice + ": ");
        System.out.println(Arrays.toString(list) + "\n");
    }

    public void detailsDisplay(double timeTaken, String type, int length) {
        System.out.println("Using " + type + ", the algorithm took");
        System.out.println(timeTaken + " seconds to sort " + length + " items");
    }

    public void comparisonDetailsDisplay(double[] timeTaken, String[] type, int length) {
        for (int i = 0; i < type.length; i++) {
            System.out.println("Using " + type[i] + ", the algorithm took");
            System.out.println(timeTaken[i] + " seconds to sort " + length + " items");
        }

    }
}
