package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        List<Character> pass = new ArrayList<>();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 8; i++) {
            pass.add(getRandomChar((byte) (Math.random()*3 + 1)));
        }
        while (!checkPass(pass)){
            pass.set((int)(Math.random()*8), getRandomChar((byte) (Math.random()*3 + 1)));
        }
        String password = "";
        for (int i = 0; i < pass.size(); i++) {
            password += pass.get(i);
        }
        for (int i = 0; i < pass.size(); i++) {
            byteArrayOutputStream.write(pass.get(i));
        }
        return byteArrayOutputStream;
    }

    public static boolean checkPass(List<Character> pass){
        boolean containsDigit = false;
        boolean containsUpperLat = false;
        boolean containsLowerLat = false;
        char c;
        for (int i = 0; i < pass.size(); i++) {
            c = pass.get(i);
            if (isDigit(c)) {
                containsDigit = true;
                continue;
            }
            if (isUpperLat(c)){
                containsUpperLat = true;
                continue;
            }
            if (isLowerLat(c)){
                containsLowerLat = true;
            }
        }
        return containsDigit && containsUpperLat && containsLowerLat;
    }

    public static boolean isDigit(char c){
        int charInt = (int) c;
        if (charInt >= 48 && charInt <= 57){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isUpperLat(char c){
        int charInt = (int) c;
        if (charInt >= 65 && charInt <= 90){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isLowerLat(char c){
        int charInt = (int) c;
        if (charInt >= 97 && charInt <= 122){
            return true;
        } else {
            return false;
        }
    }

    public static char getRandomChar(byte pick){
        int i;
        char c;
        switch (pick){
            case 1:
                i = 48 + (int) (Math.random()*10);
                c = (char) i;
                break;
            case 2:
                i = 65 + (int) (Math.random()*26);
                c = (char) i;
                break;
            case 3:
                i = 97 + (int) (Math.random()*26);
                c = (char) i;
                break;
            default:
                c = ' ';
        }
        return c;
    }
}