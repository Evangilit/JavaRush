package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(args[1]));
        Pattern p = Pattern.compile("\\S{7,}");
        Matcher m = null;
        ArrayList<String> strArr = new ArrayList<>();
        while (bfr.ready()) {
            String s = bfr.readLine();
            String[] sArr = s.split(" ");
            s = "";
            for (int j = 0; j < sArr.length; j++) {
                m = p.matcher(sArr[j]);
                if (m.find()) {
                    s += sArr[j] + ",";
                }
            }
            if (!s.equals("")) {
                strArr.add(s);
            }
        }
        bfr.close();
        strArr.set(strArr.size()-1, strArr.get(strArr.size()-1).substring(0, strArr.get(strArr.size()-1).length()-1));
        for (int i = 0; i < strArr.size(); i++) {
            bfw.write(strArr.get(i));
        }
        bfw.close();
    }
}
