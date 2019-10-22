package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        ArrayList<String> strArr = new ArrayList<>();
        BufferedReader bfr = new BufferedReader(new FileReader(name));
        while (bfr.ready()){
            strArr.add(bfr.readLine());
        }
        bfr.close();
        for (int i = 0; i < strArr.size(); i++) {
            String[] sArr = strArr.get(i).split(" ");
            int count = 0;
            for (int j = 0; j < sArr.length; j++) {
                if (words.contains(sArr[j])) count++;
            }
            if (count == 2){
                System.out.println(strArr.get(i));
            }
        }
    }
}
