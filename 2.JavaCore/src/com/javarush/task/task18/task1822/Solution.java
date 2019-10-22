package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            reader.close();
            BufferedReader bfrd = new BufferedReader(new FileReader(name));
            String s;
            String[] strArr = new String[0];
            String productName = "";
            double price = 0.0;
            int id = Integer.parseInt(args[0]), quantity = 0;
            while ((s = bfrd.readLine()) != null){
                strArr = s.split(" ");
                if (Integer.parseInt(strArr[0]) == id) break;
            }
            bfrd.close();

            for (int i = 1; i < strArr.length; i++) {
                try {
                    price = Double.parseDouble(strArr[i]);
                    quantity = Integer.parseInt(strArr[i + 1]);
                    break;
                } catch (NumberFormatException e){
                    productName += strArr[i] + " ";
                }
            }
            System.out.println(id + " " + productName + price +" " + quantity);
        } catch (IOException e) {
        }
    }
}
