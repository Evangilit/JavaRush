package com.javarush.task.task14.task1419;

import javax.management.JMException;
import javax.management.modelmbean.XMLParseException;
import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        exceptions.add(new DataFormatException());
        exceptions.add(new IllegalClassFormatException());
        exceptions.add(new IOException());
        exceptions.add(new IndexOutOfBoundsException());
        exceptions.add(new NullPointerException());
        exceptions.add(new ClassCastException());
        exceptions.add(new StringIndexOutOfBoundsException());
        exceptions.add(new GeneralSecurityException());
        exceptions.add(new JMException());


        //напишите тут ваш код

    }
}
