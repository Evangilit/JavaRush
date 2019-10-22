package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1, s2;
        try {
            s1 = reader.readLine();
            s2 = reader.readLine();
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(new File(s1)));
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File(s2)));
            String s;
            while ((s = bufferedReader1.readLine()) != null){
                allLines.add(s);
            }
            while ((s = bufferedReader2.readLine()) != null){
                forRemoveLines.add(s);
            }
            bufferedReader1.close();
            bufferedReader2.close();
            reader.close();
            new Solution().joinData();
        } catch (IOException e){
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            for (String line: forRemoveLines){
                allLines.remove(line);
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
