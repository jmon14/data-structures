package com.jamonra;

public class Main {

    public static void main(String[] args) {
        sumDigits(125);
        sumDigits(4813840);
        sumDigits(5);
    }

    public static int sumDigits(int number) {
        if (number < 10) {
            return -1;
        }
        int sum = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            sum += lastDigit;
            number = number / 10;
        }
        System.out.println(sum);
        return sum;
    }
}
