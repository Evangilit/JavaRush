package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String name = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream(name);
                if (fileInputStream.available() < 1000){
                    fileInputStream.close();
                    throw new DownloadException();
                } else {
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class DownloadException extends Exception {
        public DownloadException(){
            System.out.println("new DownLoadException");
        }
    }
}
