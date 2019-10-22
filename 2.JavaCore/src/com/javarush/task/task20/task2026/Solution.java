package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        /*byte[][] a3 = new byte[][]{
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1}
        };
        */

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        //int count3 = getRectangleCount(a3);
        //System.out.println("Last one = " + count3);
    }

    public static int getRectangleCount(byte[][] a) {
        int i = 0, j = 0, count = 0;
        while (i < a.length) {
            while (j < a[0].length) {
                if (a[i][j] == 1){
                    count++;
                    a = deleteRectangleFromArray(a, i, j);
                }
                j++;
            }
            j = 0;
            i++;
        }
        return count;
    }

    public static byte[][] deleteRectangleFromArray (byte[][] a, int ii, int jj){
        int i = ii, j = jj;
        a[i][j] = 0;
        while (j < a[0].length - 1){
            if (a[i][j+1] == 1) {
                j++;
                a[i][j] = 0;
            } else {
                break;
            }
        }
        j = jj;
        if (i < a.length -1){
            if (a[i+1][j] == 1) {
                i++;
                a = deleteRectangleFromArray(a, i, j);
            }
        }
        return a;
    }
}
