package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

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
        double maxValue = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();
        String maxKey = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Map.Entry<String, Double> pair: map.entrySet()){
            if (pair.getValue() == maxValue) treeSet.add(pair.getKey());
        }
        for (String s: treeSet){
            System.out.println(s);
        }
    }
}
