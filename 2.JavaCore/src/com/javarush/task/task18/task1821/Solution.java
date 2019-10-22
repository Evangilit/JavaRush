package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        long Starting = System.currentTimeMillis();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (reader.ready()){
                int i = reader.read();
                if (!map.containsKey(i)){
                    map.put(i, 1);
                } else {
                    int value = map.get(i) + 1;
                    map.put(i, value);
                }
            }
            reader.close();
            for (Map.Entry<Integer, Integer> pair: map.entrySet()){
                int i = pair.getKey();
                System.out.println((char)i + " " + pair.getValue());

            }
        } catch (IOException e) {
        }
        long Finishing = System.currentTimeMillis();
        System.out.println("Время выполнения: "+(Finishing-Starting)+" ms");
    }
}
