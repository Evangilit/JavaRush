package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        File pathFile = new File(path);
        File resultFile = new File(resultFileAbsolutePath);
        String newName = resultFile.getParent() + "/allFilesContent.txt";
        System.out.println(newName);
        File dest = new File(newName);
        if (FileUtils.isExist(resultFile)) {
            FileUtils.renameFile(resultFile, dest);
        }
        Solution solution = new Solution();
        File[] files = pathFile.listFiles();
        List<File> result = solution.getFilesInDirectoryLess50Bytes(pathFile, files);
        solution.sortFilesByName(result);
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i).getPath());
//        }
        solution.writeContentOfAllFiles(result, dest);
    }

    public List<File> getFilesInDirectoryLess50Bytes(File directory, File[] files){
        List<File> result = new ArrayList<>();
        for (File f: files){
            if (f.isFile()){
                long bytesSize = f.length();
                if (bytesSize <= 50){
                    result.add(f);
                }
            } else {
                File[] moreFiles = f.listFiles();
                result.addAll(getFilesInDirectoryLess50Bytes(f, moreFiles));
            }
        }
        return result;
    }

    public void sortFilesByName(List<File> list){
        for (int i = 0; i < list.size() - 1; i++) {
            String first = list.get(i).getName();
            for (int j = i; j < list.size(); j++) {
                String second = list.get(j).getName();
                if (first.compareTo(second) > 0){
                    File temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }
    }

    public void writeContentOfAllFiles(List<File> files, File dest){
        BufferedReader bfr;
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(dest));
            for (File f: files){
                bfr = new BufferedReader(new FileReader(f));
                String s;
                while ((s = bfr.readLine()) != null){
                    bfw.write(s);
                }
                bfw.write('\n');
                bfr.close();
            }
            bfw.close();
        } catch (IOException e) {
            System.out.println("Something wrong!");
        }
    }
}
