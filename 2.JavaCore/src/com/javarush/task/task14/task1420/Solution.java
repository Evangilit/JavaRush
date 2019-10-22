package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine()), n2 = Integer.parseInt(reader.readLine());
        if (n1 <= 0 || n2 <= 0){
            throw new NumberFormatException();
        }
        System.out.println(nod(n1, n2));
    }

    static int nod (int n1, int n2){
        int greater = Integer.max(n1, n2);
        int minor = Integer.min(n1, n2);
        int nod, rest =1;
        if (greater % minor == 0){
            nod = minor;
        } else {
            while (greater % minor != 0){
                rest = greater % minor;
                greater = minor;
                minor = rest;
            }
            nod =rest;
        }
        return nod;
    }
}
