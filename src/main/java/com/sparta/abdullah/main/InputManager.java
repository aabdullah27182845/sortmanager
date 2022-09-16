package com.sparta.abdullah.main;

import java.util.Scanner;

public class InputManager {
    Scanner input = new Scanner(System.in);

    public boolean userCompareInput() {
        try {
            String userInp = input.next().toLowerCase();
            char userInput = userInp.charAt(0);
            while (userInput != 'y' && userInput != 'n') {
                userInp = input.next().toLowerCase();
                userInput = userInp.charAt(0);
            }
            if (userInput == 'y') {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int userInputLength() {
        try {
            int userInput = input.nextInt();
            while (userInput <= 1) {
                System.out.println("Can't input a value that's lower than 2");
                userInput = input.nextInt();
            }
            return userInput;
        } catch (Exception e) {
            System.out.println("That's an Invalid Input");
            e.printStackTrace();
        }
        return -1;
    }

    public char userChoiceInput() {
        try {
            String userInp =  input.next().toLowerCase();
            char userInput = userInp.charAt(0);

            while (userInput != 'm' && userInput != 'b' && userInput != 't') {
                System.out.println("Only enter m, b, or t");
                userInp =  input.next().toLowerCase();
                userInput = userInp.charAt(0);
            }
            return userInput;
        } catch (Exception e) {
            System.out.println("That's bad input");
            e.printStackTrace();
        }
        return '\u0000';
    }

    public String returnStringOfChoice(char inputChar) {
        if (inputChar == 'm') return "Merge Sort";
        if (inputChar == 'b') return "Bubble Sort";
        if (inputChar == 't') return "Tree Sort";
        return "";
    }
}
