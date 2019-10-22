package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        ArrayList<Word> list = (ArrayList<Word>) detectAllWords(crossword, "home", "same", "one", "rr", "jje");
        for (Word w: list){
            System.out.println(w);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static void findAndAddWord(int[][] crossword, String word, List<Word> wordList){
        char[] wordSymbols = word.toCharArray();
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length; j++) {
                if (wordSymbols[0] == (char) crossword[i][j]){
                    Word w = new Word(word);
                    if (north(crossword, i, j, wordSymbols, 1, w)){
                        Word word1 = new Word(word);
                        word1.setStartPoint(j, i);
                        word1.setEndPoint(w.endX, w.endY);
                        wordList.add(word1);
                    }
                    if (south(crossword, i, j, wordSymbols, 1, w)){
                        Word word1 = new Word(word);
                        word1.setStartPoint(j, i);
                        word1.setEndPoint(w.endX, w.endY);
                        wordList.add(word1);
                    }
                    if (east(crossword, i, j, wordSymbols, 1, w)){
                        Word word1 = new Word(word);
                        word1.setStartPoint(j, i);
                        word1.setEndPoint(w.endX, w.endY);
                        wordList.add(word1);
                    }
                    if (west(crossword, i, j, wordSymbols, 1, w)){
                        Word word1 = new Word(word);
                        word1.setStartPoint(j, i);
                        word1.setEndPoint(w.endX, w.endY);
                        wordList.add(word1);
                    }
                    if (northEast(crossword, i, j, wordSymbols, 1, w)){
                        Word word1 = new Word(word);
                        word1.setStartPoint(j, i);
                        word1.setEndPoint(w.endX, w.endY);
                        wordList.add(word1);
                    }
                    if (northWest(crossword, i, j, wordSymbols, 1, w)){
                        Word word1 = new Word(word);
                        word1.setStartPoint(j, i);
                        word1.setEndPoint(w.endX, w.endY);
                        wordList.add(word1);
                    }
                    if (southEast(crossword, i, j, wordSymbols, 1, w)){
                        Word word1 = new Word(word);
                        word1.setStartPoint(j, i);
                        word1.setEndPoint(w.endX, w.endY);
                        wordList.add(word1);
                    }if (southWest(crossword, i, j, wordSymbols, 1, w)){
                        Word word1 = new Word(word);
                        word1.setStartPoint(j, i);
                        word1.setEndPoint(w.endX, w.endY);
                        wordList.add(word1);
                    }
                }
            }
        }
    }

    public static boolean north(int[][] crossword, int startI, int startJ, char[] wordSymbols, int i, Word w){
        while (i < wordSymbols.length) {
            try {
                if ((char) crossword[startI-1][startJ] == wordSymbols[i]){
                    i++;
                    return north(crossword, startI-1, startJ, wordSymbols, i, w);
                } else {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                return false;
            }
        }
        w.setEndPoint(startJ, startI);
        return true;
    }
    public static boolean south(int[][] crossword, int startI, int startJ, char[] wordSymbols, int i, Word w){
        while (i < wordSymbols.length) {
            try {
                if ((char) crossword[startI+1][startJ] == wordSymbols[i]){
                    i++;
                    return south(crossword, startI+1, startJ, wordSymbols, i, w);
                } else {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                return false;
            }
        }
        w.setEndPoint(startJ, startI);
        return true;
    }
    public static boolean east(int[][] crossword, int startI, int startJ, char[] wordSymbols, int i, Word w){
        while (i < wordSymbols.length) {
            try {
                if ((char) crossword[startI][startJ+1] == wordSymbols[i]){
                    i++;
                    return east(crossword, startI, startJ+1, wordSymbols, i, w);
                } else {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                return false;
            }
        }
        w.setEndPoint(startJ, startI);
        return true;
    }
    public static boolean west(int[][] crossword, int startI, int startJ, char[] wordSymbols, int i, Word w){
        while (i < wordSymbols.length) {
            try {
                if ((char) crossword[startI][startJ-1] == wordSymbols[i]){
                    i++;
                    return west(crossword, startI, startJ-1, wordSymbols, i, w);
                } else {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                return false;
            }
        }
        w.setEndPoint(startJ, startI);
        return true;
    }
    public static boolean northWest(int[][] crossword, int startI, int startJ, char[] wordSymbols, int i, Word w){
        while (i < wordSymbols.length) {
            try {
                if ((char) crossword[startI-1][startJ-1] == wordSymbols[i]){
                    i++;
                    return northWest(crossword, startI-1, startJ-1, wordSymbols, i, w);
                } else {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                return false;
            }
        }
        w.setEndPoint(startJ, startI);
        return true;
    }
    public static boolean southWest(int[][] crossword, int startI, int startJ, char[] wordSymbols, int i, Word w){
        while (i < wordSymbols.length) {
            try {
                if ((char) crossword[startI+1][startJ-1] == wordSymbols[i]){
                    i++;
                    return southWest(crossword, startI+1, startJ-1, wordSymbols, i, w);
                } else {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                return false;
            }
        }
        w.setEndPoint(startJ, startI);
        return true;
    }
    public static boolean northEast(int[][] crossword, int startI, int startJ, char[] wordSymbols, int i, Word w){
        while (i < wordSymbols.length) {
            try {
                if ((char) crossword[startI-1][startJ+1] == wordSymbols[i]){
                    i++;
                    return northEast(crossword, startI-1, startJ+1, wordSymbols, i, w);
                } else {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                return false;
            }
        }
        w.setEndPoint(startJ, startI);
        return true;
    }
    public static boolean southEast(int[][] crossword, int startI, int startJ, char[] wordSymbols, int i, Word w){
        while (i < wordSymbols.length) {
            try {
                if ((char) crossword[startI+1][startJ+1] == wordSymbols[i]){
                    i++;
                    return southEast(crossword, startI+1, startJ+1, wordSymbols, i, w);
                } else {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                return false;
            }
        }
        w.setEndPoint(startJ, startI);
        return true;
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            findAndAddWord(crossword, words[i], wordList);
        }
        return wordList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
