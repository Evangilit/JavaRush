package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(name);
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if (!map.containsKey(data)){
                map.put(data, 1);
            } else {
                map.replace(data, (map.get(data)+1));
            }
        }
        reader.close();
        fileInputStream.close();
        for (Map.Entry<Integer, Integer> pair: map.entrySet()){
            if (pair.getValue() > maxCount) maxCount = pair.getValue();
        }
        for (Map.Entry<Integer, Integer> pair: map.entrySet()){
            if (pair.getValue() == maxCount) System.out.print(pair.getKey() + " ");
        }
    }
}
