package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader bfr = new BufferedReader(new FileReader(name));
        StringBuilder sb = new StringBuilder();
        while (bfr.ready()){
            sb.append(bfr.readLine());
        }
        bfr.close();
        String string = sb.toString();
        string = string.replaceAll("[\r\n]", "");
        String openTag = "<" + args[0], closeTag = "</" + args[0] + ">";
        while (string.contains(openTag)){
            String forPrintString1 = "", forPrintString2 = "";
            forPrintString1 = string.substring(string.indexOf(openTag), string.indexOf(closeTag) + closeTag.length());
            if (forPrintString1.substring(openTag.length()).contains(openTag)){
                forPrintString2 = forPrintString1.substring(openTag.length());
                forPrintString2 = forPrintString2.substring(forPrintString2.indexOf(openTag));
                forPrintString1 = string.substring(string.indexOf(openTag), string.indexOf(closeTag, string.indexOf(closeTag) + closeTag.length()) + closeTag.length());
            }
            System.out.println(forPrintString1);
            if (!forPrintString2.equals("")){
                System.out.println(forPrintString2);
            }
            string = string.substring(string.indexOf(forPrintString1) + forPrintString1.length());
        }
    }
}
