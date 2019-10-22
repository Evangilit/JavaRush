package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPast {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:/TestFolder/Result.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("D:/TestFolder/NewResult.txt");
            while (fileInputStream.available() > 0){
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        } catch (IOException e){

        }
    }
}
