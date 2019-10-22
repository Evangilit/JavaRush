package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
        for (int i = 0; i < 2; i++) {
            Solution s = new Solution();
            for (int j = 0; j < 2; j++) {
                s.innerClasses[j] = s.new InnerClass();
            }
            solutions[i] = s;
        }
        return solutions;
    }

    public static void main(String[] args) {

    }
}
