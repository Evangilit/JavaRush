 package com.javarush.task.task22.task2209;

 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.Collections;
 import java.util.List;

 /*
 Составить цепочку слов
 */
public class Solution {
    public static void main(String[] args) {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder originalString = new StringBuilder();
        try {
            String fileName = reader.readLine();
            reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()){
                originalString.append(reader.readLine());
                //originalString.append("\t");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Something wrong");
        }
        String[] originWords = originalString.toString().split(" ");
        StringBuilder result = getLine(originWords);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(words));
        StringBuilder sb = new StringBuilder();
        if (checkOrder(words)) {
            return makeString(sb, words);
        }
        if (arrayList.isEmpty()) return sb;
        while (true){
            Collections.shuffle(arrayList);
            if (checkOrder(arrayList)){
                return makeString(sb, arrayList);
            }
        }
    }

    public static StringBuilder makeString(StringBuilder sb, String... words){
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            sb.append(' ');
        }
        return sb;
    }

    public static StringBuilder makeString(StringBuilder sb, List<String> list){
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(' ');
        }
        return sb;
    }

    public static boolean checkOrder(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            if (!words[i].substring(words[i].length()-1).equalsIgnoreCase(words[i+1].substring(0,1))){
                return false;
            }
        }
        return true;
    }
    public static boolean checkOrder(List<String> list){
        for (int i = 0; i < list.size() - 1; i++) {
            if (!list.get(i).substring(list.get(i).length()-1).equalsIgnoreCase(list.get(i+1).substring(0,1))){
                return false;
            }
        }
        return true;
    }
}
