package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[1]));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(args[2]));
            switch (args[0]){
                case "-e":
                    encodeMethod(bis, bos);
                    break;
                case "-d":
                    decodeMethod(bis, bos);
                    break;
            }
            bis.close();
            bos.close();
        } catch (IOException e) {
        }

    }

    public static void encodeMethod(BufferedInputStream bis, BufferedOutputStream bos) throws IOException{
        while (bis.available() > 0) bos.write(bis.read() + 1);
    }

    public static void decodeMethod(BufferedInputStream bis, BufferedOutputStream bos) throws IOException{
        while (bis.available() > 0) bos.write(bis.read() - 1);
    }
}
