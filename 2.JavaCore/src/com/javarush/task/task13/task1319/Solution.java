package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String f = reader.readLine();
            File file = new File(f);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            while (true){
                String s = reader.readLine();
                if (s.equals("exit")){
                    writer.write(s);
                    break;
                } else {
                    writer.write(s);
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
