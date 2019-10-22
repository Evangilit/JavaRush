package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
//        Path dest = Paths.get("D:Test/allFilesContent.txt");
//        Path source = Paths.get("D:TestFolder/allFilesContent.txt");
//        Files.move(source, dest, StandardCopyOption.REPLACE_EXISTING);
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        String prefix = urlString.substring(urlString.lastIndexOf('/') + 1, urlString.lastIndexOf('.'));
        String suffix = urlString.substring(urlString.lastIndexOf('.'));
        Path tempFile = Files.createTempFile(prefix, suffix);
        System.out.println(tempFile.getFileName());
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        if (Files.notExists(downloadDirectory)){
            Files.createDirectories(downloadDirectory);
        }
        Path dest = Paths.get(downloadDirectory.toString() + "/" + prefix + suffix);
        Files.move(tempFile, dest, StandardCopyOption.REPLACE_EXISTING);
        return dest;
    }
}
