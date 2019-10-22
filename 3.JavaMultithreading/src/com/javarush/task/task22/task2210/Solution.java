package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
        String[] result = getTokens("level22.lesson13.task01", ".");
    }
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> arrayList= new ArrayList<>();
        StringTokenizer st = new StringTokenizer(query, delimiter);
        while (st.hasMoreTokens()){
            arrayList.add(st.nextToken());
        }
        return arrayList.toArray(new String[0]);
    }
}
