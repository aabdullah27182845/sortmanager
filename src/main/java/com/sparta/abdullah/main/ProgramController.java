package com.sparta.abdullah.main;

import com.sparta.abdullah.factory.Factory;
import com.sparta.abdullah.factory.TimeCalculator;

public class ProgramController {

    InputManager inputManager = new InputManager();
    DisplayManager displayManager = new DisplayManager();
    Factory factory = new Factory();
    Factory factory2 = new Factory();
    Factory factory3 = new Factory();

    int arrLength;
    char sortingAlg;
    int[] list;
    boolean multiple;
    char[] multipleSortingAlg;

    public ProgramController() {
        this.arrLength =  100;
        this.sortingAlg = 'm';
    }

    public void main() {
        displayManager.starter();

        displayManager.listInputDisplay();
        this.arrLength = inputManager.userInputLength();
    }

    public void compareAlgorithms() {
        displayManager.multipleChoiceDisplay();
        this.multiple = inputManager.userCompareInput();

        if (!this.multiple) {
            displayManager.sortInputDisplay();
            this.sortingAlg = inputManager.userChoiceInput();
        }
    }

    public void sortArray() {
        if (!this.multiple) {
            list = factory.generateArray(this.arrLength);
            displayManager.displayUnsortedList(list);

            list = factory.factoryChoose(sortingAlg, list);
            displayManager.displaySortedList(list);

        } else {

            list = factory.generateArray(this.arrLength);
            displayManager.displayUnsortedList(list);

            int[] list1 = factory.factoryChoose('b', list);
            int[] list2 = factory2.factoryChoose('m', list);
            int[] list3 = factory3.factoryChoose('t', list);

            displayManager.displaySortedList(list1, "bubble sort");
            displayManager.displaySortedList(list2, "merge sort");
            displayManager.displaySortedList(list3, "tree sort");

        }

    }

    public void displayEnd() {
        if (!this.multiple) {
            double time = TimeCalculator.calculateTime(factory.getTimeTaken());
            String choice = inputManager.returnStringOfChoice(sortingAlg);
            displayManager.detailsDisplay(time, choice, arrLength);
        } else {
            double[] timeTaken = {TimeCalculator.calculateTime(factory.getTimeTaken()),
                    TimeCalculator.calculateTime(factory2.getTimeTaken()),
                    TimeCalculator.calculateTime(factory3.getTimeTaken())};
            String[] type = {"Bubble", "Merge", "Tree"};
            displayManager.comparisonDetailsDisplay(timeTaken, type, arrLength);
        }
    }



}
