package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
        while (bfr.ready()){
            String s = bfr.readLine();
            String s1 = s.split(" ")[0];
            double d = Double.parseDouble(s.split(" ")[1]);
            if (!map.containsKey(s1)){
                map.put(s1, d);
            } else {
                double value = map.get(s1) + d;
                map.put(s1, value);
            }
        }
        bfr.close();
        for (Map.Entry<String, Double> pair: map.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
