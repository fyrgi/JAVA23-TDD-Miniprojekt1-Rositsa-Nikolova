package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrimeNumbers pn = new PrimeNumbers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your number");
        String userInput = scanner.nextLine();
        pn.runTheProgram(userInput);
    }
}