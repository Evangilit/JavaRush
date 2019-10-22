package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d M Y");
        while (bfr.ready()){
            String s = bfr.readLine();
            String name = "";
            String[] sArr = s.split(" ");
            for (int i = 0; i < sArr.length -3; i++) {
                name += sArr[i] + " ";
            }
            Calendar calendar = new GregorianCalendar(Integer.parseInt(sArr[sArr.length - 1]), Integer.parseInt(sArr[sArr.length - 2])-1, Integer.parseInt(sArr[sArr.length - 3]));
            Date date = calendar.getTime();
            //System.out.println(name + " " + simpleDateFormat.format(date));
            PEOPLE.add(new Person(name.trim(), date));
        }
        bfr.close();
        for (Person p: PEOPLE){
            System.out.println(p.getName() + simpleDateFormat.format(p.getBirthDate()));
        }
    }
}
