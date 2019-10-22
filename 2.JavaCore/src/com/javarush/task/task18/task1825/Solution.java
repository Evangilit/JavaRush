package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strArr = new ArrayList<>();
        while (true){
            String s = reader.readLine();
            if (s.equals("end")) break;
            strArr.add(s);
        }
        String directory = strArr.get(0).substring(0, strArr.get(0).lastIndexOf('/'));
        String name = strArr.get(0).substring(strArr.get(0).lastIndexOf('/') + 1, strArr.get(0).lastIndexOf('.'));
        String fileName = directory + "/" + name;
        //System.out.println(directory + " " + name + "\n" + file);
        Set<String> strSet = new TreeSet<>();
        strSet.addAll(strArr);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(fileName), true));
        for (String s: strSet){
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(s));
            while (bis.available() > 0) {
                bos.write(bis.read());
            }
            bis.close();
        }
        bos.close();
    }

    public static class CompareStrings implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int s1 = Integer.parseInt(o1.substring(o1.lastIndexOf('t')+1));
            int s2 = Integer.parseInt(o2.substring(o2.lastIndexOf('t')+1));
            return s1 - s2;
        }
    }
}
