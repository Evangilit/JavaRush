package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]));
            String endOfName = filePath.substring(filePath.lastIndexOf('/') + 1);
            //Читаем исходный зип в карту
            Map<String, ByteArrayOutputStream> originZip = new HashMap<>();
            ZipEntry zipEntry;
            ByteArrayOutputStream byteArrayOutputStream;
            byte[] buffer = new byte[1024];
            int len;
            while ((zipEntry = zipInputStream.getNextEntry()) != null){
                byteArrayOutputStream = new ByteArrayOutputStream(buffer.length);
                while ((len = zipInputStream.read(buffer)) > 0){
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                String zipEntryName = zipEntry.getName();
                if (zipEntryName.equals("new/" + endOfName)) continue;
                originZip.put(zipEntryName, byteArrayOutputStream);
            }
            zipInputStream.close();
            //Кладем новый файл в архив в папку нью
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]));
            zipOutputStream.putNextEntry(new ZipEntry("new/" + endOfName));
            Files.copy(Paths.get(filePath), zipOutputStream);
            //Кладем сохраненный оставшейся зип
            for (Map.Entry<String, ByteArrayOutputStream> pair: originZip.entrySet()){
                zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
                zipOutputStream.write(pair.getValue().toByteArray());
            }
            zipOutputStream.close();
        } catch (IOException e) {
            System.err.println("Failure");
        }
    }



}
