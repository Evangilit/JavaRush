package com.javarush.task;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class JacksonTest {

    @JsonAutoDetect
    public static class Cat{
        @JsonProperty("newName")
        public String name;
        public int age;
         @JsonIgnore
        public int weight;
        Cat(){}

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args){
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(writer, cat);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = writer.toString();
        System.out.println(result);

        String jsonString = "{ \"newName\":\"Burka\", \"age\":5, \"weight\":4}";
        StringReader reader = new StringReader(jsonString);

        Cat cat1 = null;
        try {
            cat1 = mapper.readValue(reader, Cat.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cat1);
    }
}
