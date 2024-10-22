package org.example;

import java.util.Scanner;

public class PrimeNumbers {
    private int validUserInput;
    private boolean isNumber, inRange;
    private final int MIN_INPUT = 0, MAX_INPUT = 1000;
    public boolean isUserInputNumber(String userInput) {
        try{
            int userInputAsInt = Integer.parseInt(userInput.trim());
            validUserInput = userInputAsInt;
            isNumber = true;
            return isNumber;
        } catch (NumberFormatException e){
            isNumber = false;
            return isNumber;
        }
    }

    public boolean isUserInputInRange(int validUserInput) {
        if(validUserInput < 0 || validUserInput >= 1001){
            System.out.printf("The number should be in the range from %s to %s\n", MIN_INPUT, MAX_INPUT);
            inRange = false;
        }
        inRange = true;
        return inRange;
    }
//refactor. Need a new method to find if a number is prime before summing it.
    public int calculateSumOfPrimes(int validUserInput) {
        int sumOfPrimes = 0;
        for(int userInput = validUserInput; userInput > 2; userInput--){
            if(userInput % i == 0){
                sumOfPrimes += validUserInput;
            }
        }
        return sumOfPrimes;
    }
}
