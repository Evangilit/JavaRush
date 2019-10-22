package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static ArrayList<String> addAndRemovePairs(ArrayList<String> strings){
        try {
            for (String s: strings){
                String reverseS = new StringBuilder(s).reverse().toString();
                strings.remove(s);
                if (strings.contains(reverseS)) {
                    Pair pair = new Pair();
                    pair.first = s;
                    pair.second = reverseS;
                    result.add(pair);
                    strings.remove(reverseS);
                    return addAndRemovePairs(strings);
                }
            }
        } catch (ConcurrentModificationException e) {
            return addAndRemovePairs(strings);
        }
        return strings;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        StringBuilder aBigString = new StringBuilder();
        try (BufferedReader bfrd = new BufferedReader(new FileReader(fileName))){
            while (bfrd.ready()){
                aBigString.append(bfrd.readLine());
                aBigString.append(' ');
            }
        } catch (IOException e){
            System.out.println("Something wrong");
        }
        String[] temp = aBigString.toString().split(" ");
        ArrayList<String> tempArr = new ArrayList<>(Arrays.asList(temp));
        addAndRemovePairs(tempArr);

        for (Pair pair: result){
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
