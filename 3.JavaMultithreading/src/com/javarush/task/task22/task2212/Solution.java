package com.javarush.task.task22.task2212;

import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.equals("")) return false;
        int digits = telNumber.replaceAll("\\D", "").length();
        if (digits == 12 && telNumber.matches("^\\+{1}[a-z[A-Z]]{0}\\d+(\\(\\d{3}\\))?\\d+-?\\d+-?\\d+$")) return true;
        if (digits == 10 && telNumber.matches("^\\d?(\\(\\d{3}\\))?[a-z[A-Z]]{0}\\d+-?\\d+-?\\d+$"))return true;
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(checkTelNumber("(0)501234567"));
    }
}
