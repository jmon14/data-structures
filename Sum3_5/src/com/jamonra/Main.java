package com.jamonra;

public class Main {

    public static void main(String[] args) {
        sumby3and5();
    }

    public static void sumby3and5() {
        int sum = 0;
        int counter = 0;
        for(int i = 1; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i);
                sum += i;
                counter++;
            }
            if (counter == 5) {
                break;
            }
        }
        System.out.println(sum);
    }
}
