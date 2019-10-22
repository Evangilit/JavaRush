package Answers;

import java.io.*;
import java.util.ArrayList;

public class Lvl19Answer1 {
    public static void main(String[] args) throws IOException {
        String f1 = args[0];
        String f2 = args[1];

//        String f1 = "D:\\STUDY\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1925\\f1.txt";
//        String f2 = "D:\\STUDY\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1925\\f2.txt";


        BufferedReader reader = new BufferedReader(new FileReader(f1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
//
        //String s;
        while (reader.ready()) {
            String[] words = reader.readLine().split(" ");
            ArrayList<String> words6 = new ArrayList<>();

            for (String w : words) {
                if (w.split("").length > 6) words6.add(w);
            }

            for (int i = 0; i < words6.size() - 1; i++) {
                writer.write(words6.get(i) + ",");
            }
            if (words6.size() > 0) {
                writer.write(words6.get(words6.size() - 1) + "\n");
            }
        }
        reader.close();
        writer.close();

    }
}
