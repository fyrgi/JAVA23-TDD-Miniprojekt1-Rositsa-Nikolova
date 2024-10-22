package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test of PrimeNumbers class")
class PrimeNumbersTest {
    PrimeNumbers pn;
    @BeforeEach
    public void init(){
        pn = new PrimeNumbers();
    }

    /** first step is to ensure that the user input is a number **/
    // Check if the string from the user is a number. Refactor - string with spaces around the number
    @ParameterizedTest
    @ValueSource(strings = {"-0", "0", "653", "1000", "-1357", "  42 "})
    @DisplayName("Type of input is number")
    public void testIsUserInputNumber(String entry){
        boolean isNumber;
        assertTrue(isNumber = pn.isUserInputNumber(entry));
    }

    // Check if the string from the user is not a number
    @ParameterizedTest
    @ValueSource(strings = {"12.5", "66,1", "x103", " ", "  12 6", ""})
    @DisplayName("Type of input is not a number")
    public void testIsUserInputNotANumber(String entry){
        boolean isNumber;
        assertFalse(isNumber = pn.isUserInputNumber(entry));
    }

    /** Second step is to ensure that the user input is in the desired range **/
    @ParameterizedTest
    @ValueSource(ints = {-0, 0, 653, 1000})
    @DisplayName("User input is in range")
    public void testIsUserInputInRange(int userInput){
        boolean inRange;
        assertTrue(inRange = pn.isUserInputInRange(userInput));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1001})
    @DisplayName("User input is Out of range")
    public void testIsUserInputOutOfRange(int userInput){
        boolean inRange;
        assertTrue(inRange = pn.isUserInputInRange(userInput));
    }

    /** after the system has checked the input type and the range it is time to do some calculations,
     * but not yet print the result **/
    // After a refactor a new helping method is created to check if a number is prime.
    @Test
    @DisplayName("Is number a prime")
    public void testCheckIfTheNumberIsPrime(){
        boolean isPrime;
        assertTrue(isPrime = pn.isTheNumberPrime(17));
        assertFalse(isPrime = pn.isTheNumberPrime(18));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 10",
            "666, 36888",
            "1000, 76127"
    })
    @DisplayName("All prime numbers SUM")
    public void testSumOfAllPrimeNumbersInRange(int validUserInput, int expectedSumOfPrimes){
        assertEquals(expectedSumOfPrimes, pn.calculateSumOfPrimes(validUserInput));
    }

    @Test
    @DisplayName("Check message about the sum")
    public void testTheDisplayMessageAboutTheSum(){
        assertEquals("The sum of all prime numbers between 0 and 666 is 36888\n", pn.printSum(666, 36888));
    }

    @Test
    @DisplayName("Check message about the sum")
    public void testTheDisplayMessageAboutTheCount(){
        assertEquals("The amount of all prime numbers between 0 and 5 is 3\n", pn.printCount(5, 3));
    }
}