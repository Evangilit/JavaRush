package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;

/* 
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();

        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        ArrayDeque<Integer> integerArrayDeque = getIntegerArrayDequeOfAllModifiers(allModifiers);
        if (integerArrayDeque.contains(specificModifier)) return true;
        return false;
    }

    public static ArrayDeque<Integer> getIntegerArrayDequeOfAllModifiers(int allModifiers){
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        int degree = 0;
        while (true){
            if (allModifiers == 0) break;
            if (Math.pow(2, ++degree) > allModifiers){
                degree--;
                integerArrayDeque.add( (int) Math.pow(2, degree));
                allModifiers -= integerArrayDeque.getLast();
                degree = 0;
            }
        }
        return integerArrayDeque;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }
        return null;
    }
}
