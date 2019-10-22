package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException{
        /*String fileName = "D:TestFolder/file2.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        PersonScannerAdapter pscad = new PersonScannerAdapter(scanner);
        System.out.println(pscad.read());
        SimpleDateFormat sdf = new SimpleDateFormat("d M y");
        Date date = new Date();
        System.out.println(sdf.format(date));
         */
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public void close() {
            fileScanner.close();
        }

        @Override
        public Person read() throws IOException {
            String[] s = fileScanner.nextLine().split(" ");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d M y");
            Date birthDay = null;
            try {
                birthDay = simpleDateFormat.parse(String.format("%s %s %s",s[3],s[4],s[5]));
            } catch (ParseException e) {
            }
            return new Person(s[1], s[2], s[0], birthDay);
        }
    }
}
