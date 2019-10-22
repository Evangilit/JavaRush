package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String cutS = s.substring(s.indexOf("?") + 1);
        String parmtr = "";
        String objct = "";
        StringBuilder parametr = new StringBuilder("");
        StringBuilder object = new StringBuilder("");
        for (int i = 0; i < cutS.length(); i++) {
            if (cutS.charAt(i) != '&'){
                if (cutS.charAt(i) != '='){
                    parametr.append(cutS.charAt(i));
                } else {
                    parmtr = parametr.toString();
                    System.out.print(parmtr + " ");
                    if ((parmtr = parametr.toString()).equals("obj")){
                        int j = i+1;
                        while ((j < cutS.length()) && (cutS.charAt(j) != '&')){
                            object.append(cutS.charAt(j));
                            j++;
                        }
                        i = j;
                        objct = object.toString();
                    } else {
                        int j = i;
                        while ((j < cutS.length()) && (cutS.charAt(j) != '&')){
                            j++;
                        }
                        i = j;
                    }
                    parametr.delete(0, parametr.capacity());
                }
            } else {
                parmtr = parametr.toString();
                System.out.print(parmtr + " ");
                parametr.delete(0, parametr.capacity());
            }
        }

        if (!objct.equals("")){
            System.out.println("");
            try {
                alert(Double.parseDouble(objct));
            } catch (NumberFormatException e){
                alert(objct);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
