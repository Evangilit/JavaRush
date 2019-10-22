package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(outputStream);
        testString.printSomething();
        System.setOut(consoleStream);
        String[] strArr = byteArrayOutputStream.toString().split(" ");
        int result = 0;
        switch (strArr[1]){
            case "+":
                result = Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[2]);
                break;
            case "-":
                result = Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[2]);
                break;
            case "*":
                result = Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[2]);
                break;
        }
        String strResult = String.format("%s %s %s %s %s", strArr[0], strArr[1], strArr[2], strArr[3], result);
        System.out.println(strResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

