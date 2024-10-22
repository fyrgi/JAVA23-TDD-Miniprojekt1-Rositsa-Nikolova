package org.example;

import java.util.Scanner;

public class PrimeNumbers {
    private int validUserInput, sumOfPrimes = 0, countOfPrimeNumbersInTheRange = 0;
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
        sumOfPrimes = 0;
        countOfPrimeNumbersInTheRange = 0;
        for(int i = 0; i <= validUserInput; i++){
            if(isTheNumberPrime(i)){
                sumOfPrimes += i;
                countOfPrimeNumbersInTheRange++;
            }
        }
        //System.out.println(sumOfPrimes);
        //System.out.println(countOfPrimeNumbersInTheRange);
        return sumOfPrimes;
    }

    public boolean isTheNumberPrime(int number) {
        // 1 and 0 are not prime numbers
        if (number <= 1) {
            return false;
        }
        // Because 1 is not a prime, the count starts from 2.
        for (int i = 2; i <= Math.sqrt(number); i++) {
            // If the number ca be divided by any number other than 1 and itself, it's not prime
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String printSum(int validUserInput, int sumOfPrimes) {
       String message = String.format("The sum of all prime numbers between %s and %s is %s\n", MIN_INPUT, validUserInput, sumOfPrimes);
       return message;
    }

    public String printCount(int validUserInput, int countOfPrimeNumbersInTheRange) {
        String message = String.format("The amount of all prime numbers between %s and %s is %s\n", MIN_INPUT, validUserInput, countOfPrimeNumbersInTheRange);
        System.out.println(countOfPrimeNumbersInTheRange);
        return message;
    }
}
