package com.sparta.abdullah.main;


import com.sparta.abdullah.controller.ProgramController;

public class Main {
    public static void main(String[] args) {
        ProgramController pc = new ProgramController();
        pc.main();
        pc.compareAlgorithms();
        pc.sortArray();
        pc.displayEnd();
    }
}