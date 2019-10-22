package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties prpts = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream fis = new FileInputStream(name);
        load(fis);

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prpts.putAll(properties);
        prpts.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prpts.load(inputStream);
        for (String name: prpts.stringPropertyNames())
            properties.put(name, prpts.getProperty(name));
    }

    public static void main(String[] args) throws Exception {
        /*
        properties.put("website", "https://ru.wikipedia.org/");
        properties.put("language", "Russian");
        properties.put("path:", "c:\\\\wikipedia\\\\templates");
        Solution s = new Solution();
        FileOutputStream fos = new FileOutputStream("D:TestFolder/prop.properties");
        s.save(fos);
        properties.clear();
        for (Map.Entry<String, String> pair: properties.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        s.fillInPropertiesMap();
        for (Map.Entry<String, String> pair: properties.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        */
    }
}
