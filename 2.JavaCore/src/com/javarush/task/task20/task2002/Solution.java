package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("D:TestFolder/file1.txt");
            InputStream inputStream = new FileInputStream("D:TestFolder/file1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            User one = javaRush.users.get(0);
            one.setFirstName("Jack");
            one.setLastName("Richer");
            one.setBirthDate(new Date());
            one.setMale(true);
            one.setCountry(User.Country.RUSSIA);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pr = new PrintWriter(outputStream);
            if (users != null){
                for (int i = 0; i < users.size(); i++) {
                    pr.println(users.get(i).getFirstName());
                    pr.println(users.get(i).getLastName());
                    pr.println(users.get(i).getBirthDate().getTime());
                    pr.println(users.get(i).isMale());
                    pr.println(users.get(i).getCountry().getDisplayName());
                }
            }
            pr.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()){
                User user = new User();
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                Date date = new Date(Long.parseLong(reader.readLine()));
                boolean isMale = Boolean.parseBoolean(reader.readLine());
                String c = reader.readLine();
                User.Country country = null;
                switch (c){
                    case "Ukraine":
                        country = User.Country.UKRAINE;
                        break;
                    case "Russia":
                        country = User.Country.RUSSIA;
                        break;
                    case "Other":
                        country = User.Country.OTHER;
                        break;
                }
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setBirthDate(date);
                user.setMale(isMale);
                user.setCountry(country);
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
