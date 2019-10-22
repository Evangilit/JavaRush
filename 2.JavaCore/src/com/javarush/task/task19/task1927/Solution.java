package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(outputStream);
        testString.printSomething();
        String[] arr = byteArrayOutputStream.toString().split("\\n");
        ArrayList<String> strArr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            strArr.add(arr[i]);
            if ( i%2 != 0) strArr.add("JavaRush - курсы Java онлайн");
        }
        System.setOut(console);
        for (int i = 0; i < strArr.size(); i++) {
            System.out.println(strArr.get(i));
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
