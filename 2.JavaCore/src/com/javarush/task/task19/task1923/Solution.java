package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(args[1]));
        Pattern p = Pattern.compile("\\d+");
        Matcher m = null;
        while (bfr.ready()){
            String s = bfr.readLine();
            String[] sArr = s.split(" ");
            for (int i = 0; i < sArr.length; i++) {
                m = p.matcher(sArr[i]);
                if (m.find()) bfw.write(sArr[i] + " ");
            }
        }
        bfr.close();
        bfw.close();
    }
}
