package com.sparta.abdullah.factory;

import com.sparta.abdullah.main.ProgramController;
import com.sparta.abdullah.sorters.BubbleSort;
import com.sparta.abdullah.sorters.MergeSort;
import com.sparta.abdullah.sorters.TreeSort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Random;

public class Factory {
    long timeTaken;

    public static Logger logger = (Logger) LogManager.getLogger(ProgramController.class);

    public int[] generateArray(int length) {
        Random random = new Random();
        int[] outputArr = new int[length];
        for (int i = 0; i < length; i++) {
            outputArr[i] = random.nextInt(length + 1);
        }
        return outputArr;
    }

    public int[] factoryChoose(char choice, int[] unsorted) {

        if (choice == '\u0000') return new int[] {};
        Character Choice = (Character) choice;
        Choice = Character.toLowerCase(Choice);
        if (Choice != 'm' & Choice != 'b' & Choice != 't') {
            return new int[] {};
        }

        if (Choice.equals('m')) {

            MergeSort ms = new MergeSort();
            int[] sorted = ms.sortArray(unsorted);
            this.timeTaken = ms.getTimeTaken();
            return sorted;


        } else if (Choice.equals('b')) {

            BubbleSort bs = new BubbleSort();
            int[] sorted = bs.sortArray(unsorted);
            this.timeTaken = bs.getTimeTaken();
            return sorted;

        } else {
            TreeSort ts = new TreeSort();
            this.timeTaken = System.nanoTime();
            int[] arr = ts.sortArray(unsorted);
            this.timeTaken = System.nanoTime() - timeTaken;
            return arr;
        }
    }

    public long getTimeTaken() {
        return this.timeTaken;
    }
}
