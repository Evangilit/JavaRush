package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Vector;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        String resultFileName = args[0];
        TreeSet<String> stringArgs = new TreeSet<>();
        for (int i = 1; i < args.length; i++) {
            stringArgs.add(args[i]);
        }
        Vector<FileInputStream> files = new Vector<>();
        try {
            while (!stringArgs.isEmpty()) {
                files.addElement(new FileInputStream(stringArgs.pollFirst()));
            }
            ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(files.elements()));
            FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
            byte[] buffer = new byte[512];
            while ((zipInputStream.getNextEntry()) != null){
                int len;
                while ((len = zipInputStream.read(buffer)) > 0){
                    fileOutputStream.write(buffer, 0, len);
                }
            }
            zipInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.err.println("Failure");
        }
    }
}
