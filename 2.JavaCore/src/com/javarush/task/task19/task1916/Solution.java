package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine(), name2 = reader.readLine();
        reader.close();
        ArrayList<String> file1Arr = new ArrayList<>();
        ArrayList<String> file2Arr = new ArrayList<>();
        BufferedReader bfr1 = new BufferedReader(new FileReader(name1));
        BufferedReader bfr2 = new BufferedReader(new FileReader(name2));
        while (bfr1.ready()) file1Arr.add(bfr1.readLine());
        bfr1.close();
        while (bfr2.ready()) file2Arr.add(bfr2.readLine());
        bfr2.close();
        while ((file2Arr.size() != 0) && (file1Arr.size() != 0)) {
            if (file2Arr.get(0).equals(file1Arr.get(0))){
                lines.add(new LineItem(Type.SAME, file2Arr.get(0)));
                file1Arr.remove(0);
                file2Arr.remove(0);
            } else if (file2Arr.get(0).equals(file1Arr.get(1))){
                lines.add(new LineItem(Type.REMOVED, file1Arr.get(0)));
                file1Arr.remove(0);
            } else {
                lines.add(new LineItem(Type.ADDED, file2Arr.get(0)));
                file2Arr.remove(0);
            }
        }
        while (file1Arr.size() != 0) {
            lines.add(new LineItem(Type.REMOVED, file1Arr.get(0)));
            file1Arr.remove(0);
        }
        while (file2Arr.size() != 0) {
            lines.add(new LineItem(Type.ADDED, file2Arr.get(0)));
            file2Arr.remove(0);
        }
        /*for (LineItem item: lines){
            System.out.println(item.type + " " + item.line);
        }
        */
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
