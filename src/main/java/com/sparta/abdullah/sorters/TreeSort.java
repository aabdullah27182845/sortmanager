package com.sparta.abdullah.sorters;

import com.sparta.abdullah.structures.BinarySearchTree;

public class TreeSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int number: arrayToSort) {
            tree.add(number);
        }
        return tree.inOrderTraversal();
    }
}
