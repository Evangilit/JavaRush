package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

     }
    
    static {
        reset();
    }

    public static CanFly result;

    public static void reset(){
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String parametr = reader.readLine();
            if (parametr.equals("helicopter")){
                result = new Helicopter();
            } else if (parametr.equals("plane")){
                int p = Integer.parseInt(reader.readLine());
                result = new Plane(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e){
            }
        }
    }
}
