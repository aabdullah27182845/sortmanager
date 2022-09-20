package com.sparta.abdullah.main;

import com.sparta.abdullah.factory.Factory;
import com.sparta.abdullah.factory.TimeCalculator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProgramController {

    public static Logger logger = LogManager.getLogger(ProgramController.class);

    InputManager inputManager = new InputManager();
    DisplayManager displayManager = new DisplayManager();
    Factory factory = new Factory();
    Factory factory2 = new Factory();
    Factory factory3 = new Factory();

    int arrLength;
    char sortingAlg;
    String sorter;
    int[] list;
    boolean multiple;
    char[] multipleSortingAlg;

    public ProgramController() {
        this.arrLength =  100;
        this.sortingAlg = 'm';
    }

    public void setSorter(char so) {
        if (so == 'm') {
            this.sorter = "Merge Sort";
        } else if (so == 'b') {
            this.sorter = "Bubble Sort";
        } else {
            this.sorter = "Tree Sort";
        }
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

            this.setSorter(this.sortingAlg);
            logger.log(Level.TRACE, "Time taken for using " + this.sorter + " is " + this.factory.getTimeTaken());

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
