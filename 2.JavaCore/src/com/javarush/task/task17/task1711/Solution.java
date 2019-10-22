package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        Person person;
        Date date;
        int i;
        switch (args[0]){
            case "-c":
                synchronized (allPeople){
                    i = 1;
                    while (i < args.length){
                        date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+2]);
                        if (args[i+1].equals("м")){
                            allPeople.add(Person.createMale(args[i], date));
                        } else {
                            allPeople.add(Person.createFemale(args[i], date));
                        }
                        System.out.println(allPeople.size()-1);
                        i = i + 3;
                    }
                    break;
                }

            case "-u":
                synchronized (allPeople){
                    i = 1;
                    while (i < args.length){
                        date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+3]);
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(args[i+1]);
                        person.setSex( args[i+2].equals("м")? Sex.MALE: Sex.FEMALE);
                        person.setBirthDate(date);
                        i = i + 4;
                    }
                    break;
                }

            case "-d":
                synchronized (allPeople){
                    i = 1;
                    while (i < args.length){
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                        allPeople.set(Integer.parseInt(args[i]), person);
                        i++;
                    }
                    break;
                }

            case "-i":
                synchronized (allPeople) {
                    i = 1;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    while (i < args.length){
                        person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(person.getName() + " " + (person.getSex().equals(Sex.MALE)? "м": "ж") + " " + simpleDateFormat.format(person.getBirthDate()));
                        i++;
                    }
                    break;
                }
        }
    }
}
