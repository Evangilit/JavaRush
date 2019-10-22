package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        String check;

        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getValue() != null) {
                sb.append(pair.getKey());
                sb.append(" = '");
                sb.append(pair.getValue());
                sb.append('\'');
                if (iterator.hasNext()){
                    sb.append(" and ");
                }
            }
        }
        /*
        for (Map.Entry<String, String> pair: params.entrySet()){
            if (pair.getValue() != null) {
                sb.append(pair.getKey());
                sb.append(" = '");
                sb.append(pair.getValue());
                sb.append('\'');
            }
        }
        */
        check = sb.toString();
        if (check.endsWith(" and ")){
            check = check.substring(0, check.length()-5);
        }
        return check;
    }
}
