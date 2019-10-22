package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> directoryQueue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        File rootFile = new File(root);
        if (!rootFile.isDirectory()){
            throw new IOException("the root is not a directory");
        }
        directoryQueue.add(rootFile);
        while (!directoryQueue.isEmpty()){
            File[] files = directoryQueue.poll().listFiles();
            for (File f: files){
                if (f.isDirectory()){
                    directoryQueue.add(f);
                } else {
                    result.add(f.getAbsolutePath());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
//        for (String s: getFileTree("D:Test")){
//            System.out.println(s);
//        }
    }
}
