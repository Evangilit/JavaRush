package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix (int m, String value, int n){

    }

    public static void printMatrix (Integer n, Integer m, String value){

    }

    public static void printMatrix (String value, int n, int m){

    }

    public static void printMatrix (Integer m, String value, Integer n) {

    }

    public static void printMatrix (String value, Integer m, Integer n){

    }

    public static void printMatrix (String value, int m, Integer n){

    }

    public static void printMatrix (String value, Integer m, int n){

    }

    public static void printMatrix (int m, Integer n, String value){}
}
