package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object n) {
        if (this == n) return true;
        if (n == null) return false;
        if (!(n instanceof Solution)) return false;
        Solution another = (Solution)n;
        if (this.first != null && another.first != null){
            if (this.last != null && another.last != null){
                return another.first.equals(this.first) && another.last.equals(this.last);
            } else {
                if (this.last == null && another.last == null){
                    return another.first.equals(this.first);
                }
            }
        } else {
            if (this.first == null && another.first == null){
                if (this.last == null && another.last == null){
                    return true;
                } else {
                    return another.last.equals(this.last);
                }
            }
        }
        return false;
    }
    @Override
    public int hashCode() {
        if (first == null && last == null){
            return -31;
        } else if (first == null){
            return 31 * last.hashCode();
        } else if (last == null){
            return 31 * first.hashCode();
        } else {
            return 31 * first.hashCode() + last.hashCode();
        }

    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        //s.add(new Solution("Donald", "Duck"));
        s.add(new Solution(null, null));
        //System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(s.contains(new Solution(null, null)));
    }
}
