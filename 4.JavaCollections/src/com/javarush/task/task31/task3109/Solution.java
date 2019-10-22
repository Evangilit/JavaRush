package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);

    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        String simpleFileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
        try {
            FileInputStream in = new FileInputStream(fileName);
            if (simpleFileName.endsWith(".xml")){
                properties.loadFromXML(in);
            } else {
                properties.load(in);
            }
        } catch (IOException e) {
            //System.err.println("Error");
        }
        return properties;
    }
}
