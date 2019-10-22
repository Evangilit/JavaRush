package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String temp = "";
        try {
            //заместо иф мог бы бать метод stripLeading(), но в se8 его еще не было
            if (string.startsWith(" ")) {
                string = string.substring(string.indexOf(' ')+1);
            }
            String[] stringArr = string.split(" ");
            temp = stringArr[1] + " " + stringArr[2] + " " + stringArr[3] + " " + stringArr[4];
        } catch (RuntimeException e) {
            throw new TooShortStringException();
        }
        return temp;
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
