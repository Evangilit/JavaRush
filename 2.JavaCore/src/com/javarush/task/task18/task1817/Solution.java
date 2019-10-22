package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) {
        try {
            double s = 0, p = 0;
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            while (fileInputStream.available() > 0){
                Character c = (char) fileInputStream.read();
                s++;
                if (c.equals(' ')) p++;
            }
            fileInputStream.close();
            double result = p/s*100;
            BigDecimal bigDecimal = new BigDecimal(result);
            result = bigDecimal.setScale(2, RoundingMode.UP).doubleValue();
            System.out.println(result);
        } catch (IOException e) {
        }
    }
}
