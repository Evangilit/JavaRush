package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 0) {
            switch (args[0]){
                case "-c":
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String name = reader.readLine();
                    reader = new BufferedReader(new FileReader(name));
                    ArrayList<String> strArr = new ArrayList<>();
                    String s;
                    while ((s = reader.readLine()) != null){
                        strArr.add(s);
                    }
                    reader.close();
                    int maxID = 0;
                    for (int i = 0; i < strArr.size(); i++) {
                        String s1 = strArr.get(i).substring(0,8);
                        for (int j = 0; j < s1.length(); j++) {
                            if (!Character.isDigit(s1.charAt(j))){
                                System.out.println(s1.charAt(j));
                                s1 = s1.substring(0, j);
                                break;
                            }
                        }
                        int id = Integer.parseInt(s1);
                        if (id > maxID) maxID = id;
                    }
                    maxID++;
                    int i = 1;
                    String productName = "";
                    for (int j = 1; j < args.length; j++) {
                        try {
                            double d = Double.parseDouble(args[j]);
                            i = j;
                            productName = productName.substring(0, productName.length()-1);
                            break;
                        } catch (NumberFormatException e){
                            productName += (args[j] + " ");
                        }
                    }
                    String createStr = maxID + makeArg(productName, 30) + makeArg(args[i], 8) + makeArg(args[i+1], 4);
                    System.out.println(createStr);
                    BufferedWriter bfw = new BufferedWriter(new FileWriter(name, true));
                    bfw.newLine();
                    bfw.write(createStr);
                    bfw.close();
                    break;
            }
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
