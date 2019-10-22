package com.javarush.task.task21.task2101;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
        //print(new byte[]{(byte) 128, 13, (byte) 130, 21, (byte) 155});
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        int[] netAddressInt = new int[4];
        byte[] netAddress = new byte[4];
        int ipVar, maskVar;
        for (int i = 0; i < 4; i++) {
            ipVar = getIntFromByte(ip[i]);
            maskVar = getIntFromByte(mask[i]);
            netAddressInt[i] = ipVar & maskVar;
            netAddress[i] = (byte) netAddressInt[i];
            //System.out.println(netAddress[i]);
        }
        return netAddress;
    }

    public static void print(byte[] bytes) {
        String byteString;
        int intVar;
        for (int i = 0; i < bytes.length; i++) {
            intVar = getIntFromByte(bytes[i]);
            byteString = String.format("%8s", Integer.toBinaryString(intVar)).replace(' ', '0');
            System.out.print(byteString + " ");
        }
        System.out.println();
    }

    public static int getIntFromByte (byte b){
        if (b < 0) {
            return b + 256;
        } else {
            return b;
        }
    }
}
