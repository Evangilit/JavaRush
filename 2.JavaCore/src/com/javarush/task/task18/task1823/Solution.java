package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String s = reader.readLine();
                if (s.equals("exit")) break;
                new ReadThread(s).start();
            }
        } catch (IOException e) {
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        @Override
        public void run(){
            int maxByte = Integer.MIN_VALUE, maxCountByte = 0;
            byte[] buffer = new byte[255];
            try {
                FileInputStream fis = new FileInputStream(fileName);
                while (fis.available() > 0){
                    buffer[fis.read()]++;
                }
                fis.close();
            } catch (IOException e) {
            }
            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] > maxCountByte) {
                    maxCountByte = buffer[i];
                    maxByte = i;
                }
            }
            resultMap.put(fileName, maxByte);
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
