package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;

/*
Алгоритмы-числа
*/
public class Solution {

    private final static long[][] DEGREE_MATRIX = new long[10][20];

    static {
        for (int degree = 1; degree < 20; degree++){
            DEGREE_MATRIX[0][degree] = 0;
        }
        for (int degree = 1; degree < 20; degree++){
            DEGREE_MATRIX[1][degree] = 1;
        }
        for (int currentNum = 2; currentNum < 10; currentNum++) {
            for (int degree = 1; degree < 20; degree++){
                DEGREE_MATRIX[currentNum][degree] = currentNum;
                for (int i = 1; i < degree; i++) {
                    DEGREE_MATRIX[currentNum][degree] = DEGREE_MATRIX[currentNum][degree]*currentNum;
                }
            }
        }
    }

    public static long[] getNumbers(long N) {
        ArrayList<Long> arr = new ArrayList<>();
        if (N > 9) {
            for (long i = 1; i < 10; i++) {
                arr.add(i);
            }
            long currentNumber = 10;
            while (currentNumber < N && currentNumber < 9000000000000000000L){
                int countsOfDigits = getCountsOfDigits(currentNumber);
                long tryArmstrong = squareSum(currentNumber, countsOfDigits);
                if (countsOfDigits == getCountsOfDigits(tryArmstrong)) {
                    if (isArmstrong(tryArmstrong) && tryArmstrong < N){
                        arr.add(tryArmstrong);
                    }
                }
                currentNumber = incrementCount(currentNumber);
            }
        } else {
            for (long i = 1; i < N; i++) {
                arr.add(i);
            }
        }
        Collections.sort(arr);
        long[] result = new long[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        long [] longs = getNumbers(Long.MAX_VALUE);
        for (int i = 0; i < longs.length; i++) {
            System.out.print(longs[i] + " ");
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time spend: " + (finish-start) + " ms");

        //long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        //System.out.println(usedBytes/1048576);

    }

    private static boolean isArmstrong (long number){
        int countsOfDigits = getCountsOfDigits(number);
        return squareSum(number, countsOfDigits) == number;
    }

    public static int getCountsOfDigits(long number) {
        return(number == 0) ? 1 : (int) Math.ceil(Math.log10(number));
    }
// сумму вроде тоже правильно считает
    private static long squareSum (long number, int countsOfDigits){
        long sum = 0;
        while (number!= 0){
            int num = (int) (number%10);
            sum += DEGREE_MATRIX[num][countsOfDigits];
            number /= 10;
        }
        return sum;
    }
// перебор теперь работает правильно
    private static long incrementCount (long currCount){
        if (currCount % 10 != 0){
            return ++currCount;
        } else {
            int count = 0;
            while (currCount % 10 == 0){
                currCount /= 10;
                count++;
            }
            long deci = 1;
            for (int i = 1; i <= count; i++) {
                deci *= 10;
            }
            currCount = (currCount%10)*(deci/10) + currCount*deci;
            return currCount;
        }
    }
}
