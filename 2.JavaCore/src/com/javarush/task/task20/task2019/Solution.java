package com.javarush.task.task20.task2019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Исправить ошибку. Сериализация
*/
public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("D:TestFolder/file.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        outputStream.close();
        fileOutput.close();

        //load
        FileInputStream fiStream = new FileInputStream("D:TestFolder/file.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        objectStream.close();
        fiStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    public Solution() {
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }



    public int size() {
        return m.size();
    }
}
