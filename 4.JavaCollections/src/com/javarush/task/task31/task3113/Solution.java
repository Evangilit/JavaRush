package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Path directoryPath = Paths.get(s);
        if (!Files.isDirectory(directoryPath)){
            System.out.println(s + " - не папка");
            return;
        }
        Solution solution = new Solution();
        long[] result = solution.getInfoAboutDirectory(directoryPath);
        solution.printInfo(result);
    }

    public long[] getInfoAboutDirectory(Path directoryPath){
        MyFileVisitor myFileVisitor = new MyFileVisitor();
        long[] info = new long[3];
        try {
            Files.walkFileTree(directoryPath, myFileVisitor);
            info[0] = myFileVisitor.getDirectoriesCount();
            info[1] = myFileVisitor.getFilesCount();
            info[2] = myFileVisitor.getTotalBytes();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return info;
    }

    public void printInfo(long[] info){
        System.out.println("Всего папок - " + info[0]);
        System.out.println("Всего файлов - " + info[1]);
        System.out.println("Общий размер - " + info[2]);
    }

    public class MyFileVisitor extends SimpleFileVisitor<Path>{
        private long filesCount;
        private long directoriesCount = -1;
        private long totalBytes;

        public long getFilesCount() {
            return filesCount;
        }

        public long getDirectoriesCount() {
            return directoriesCount;
        }

        public long getTotalBytes() {
            return totalBytes;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            totalBytes += attrs.size();
            if (Files.isRegularFile(file)){
                filesCount++;
            }
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            directoriesCount++;
            return super.postVisitDirectory(dir, exc);
        }
    }
}
