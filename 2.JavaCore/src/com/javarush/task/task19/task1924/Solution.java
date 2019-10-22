package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader bfr = new BufferedReader(new FileReader(name));
        ArrayList<String> strArr = new ArrayList<>();
        while (bfr.ready()) strArr.add(bfr.readLine());
        bfr.close();
        for (int i = 0; i < strArr.size(); i++) {
            String[] sArr = strArr.get(i).split(" ");
            for (int j = 0; j < sArr.length; j++) {
                try {
                    int k = Integer.parseInt(sArr[j]);
                    if (map.containsKey(k)){
                        sArr[j] = map.get(k);
                    }
                } catch (NumberFormatException e){ }
            }
            String result = "";
            for (int j = 0; j < sArr.length; j++) {
                result += sArr[j] + " ";
            }
            strArr.set(i, result);
        }
        for (String s: strArr){
            System.out.println(s);
        }

    }
}
