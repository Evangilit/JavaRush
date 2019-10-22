package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean allSatisfied = true;
        if (partOfName != null) {
            if (!file.toString().contains(partOfName)) {
                allSatisfied = false;
            }
        }
        String contentString = new String(content);
        if (partOfContent != null) {
            if (!contentString.contains(partOfContent)) {
                allSatisfied = false;
            }
        }
        if (minSize != 0){
            if (content.length <= minSize) {
                allSatisfied = false;
            }
        }
        if (maxSize != 0){
            if (content.length >= maxSize) {
                allSatisfied = false;
            }
        }
        if (allSatisfied){
            foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
