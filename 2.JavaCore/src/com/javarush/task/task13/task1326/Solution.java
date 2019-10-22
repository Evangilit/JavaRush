package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(s);
            String f;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while ((f = bufferedReader.readLine()) != null){
                array.add(Integer.parseInt(f));
            }

            fileInputStream.close();
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        sort(array);
        for (int i = 0; i < array.size(); i++) {

            if (array.get(i) % 2 == 0) {
                System.out.println(array.get(i));
            }
        }
    }

    static void sort (ArrayList<Integer> arr){
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = 0; j < arr.size()-1; j++) {
                if (arr.get(j+1) < arr.get(j)){
                    int t = arr.get(j+1);
                    arr.set(j+1, arr.get(j));
                    arr.set(j, t);
                }
            }
        }
    }
}
