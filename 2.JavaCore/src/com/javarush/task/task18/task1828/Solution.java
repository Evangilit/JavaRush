package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException{
        if (args.length != 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine(), s, target = "";
            ArrayList<String> strArr = new ArrayList<>();
            reader = new BufferedReader(new FileReader(name));
            while ((s = reader.readLine()) != null) {
                if (s.substring(0,8).trim().equals(args[1])){
                    switch (args[0]){
                        case "-u":
                            String productName = "";
                            int i = 2;
                            for (int j = 2; j < args.length; j++) {
                                try {
                                    double d = Double.parseDouble(args[j]);
                                    i = j;
                                    productName = productName.substring(0, productName.length() - 1);
                                    break;
                                } catch (NumberFormatException e) {
                                    productName += (args[j] + " ");
                                }
                            }
                            String createStr = makeArg(args[1], 8) + makeArg(productName, 30) + makeArg(args[i], 8) + makeArg(args[i + 1], 4);
                            strArr.add(createStr);
                            continue;
                        case "-d":
                            continue;
                    }
                }
                strArr.add(s);
            }
            reader.close();
            BufferedWriter bfw = new BufferedWriter(new FileWriter(name));
            for (int i = 0; i < strArr.size(); i++) {
                System.out.println(strArr.get(i));
                bfw.write(strArr.get(i));
                bfw.newLine();
            }
            bfw.close();
        }
    }

    public static String makeArg (String s, int length){
        int difference = length - s.length();
        if (difference > 0){
            for (int i = 0; i < difference; i++) {
                s += " ";
            }
        } else if (s.length() > length){
            s = s.substring(0, length);
        }
        return s;
    }
}