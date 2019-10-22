package Answers;

import java.io.*;
import java.util.ArrayList;

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter bufWriter = new BufferedWriter( new FileWriter(reader.readLine()));
        //    ArrayList<Character> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        while (bufReader.ready()){
            builder.append((char) bufReader.read());
        }
        String str = builder.toString();
        //      String str = new String(list);//String.valueOf(list);
        String[] a = str.split("\\s");
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            try{
                int digit = Integer.parseInt(a[i]);
                result.add(digit);
                //https://ru.stackoverflow.com/questions/58760/%D0%9A%D0%B0%D0%BA-%D0%BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D0%B8%D1%82%D1%8C-%D1%8F%D0%B2%D0%BB%D1%8F%D0%B5%D1%82%D1%81%D1%8F-%D0%BB%D0%B8-%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B0-%D1%87%D0%B8%D1%81%D0%BB%D0%BE%D0%BC
            }
            catch(NumberFormatException e){
                continue;
            }
        }
        // bufWriter.write(a);
        for (int i = 0; i < result.size(); i++) {
            bufWriter.write(result.get(i));
            bufWriter.write(" ");
        }

        reader.close();
        bufReader.close();
        bufWriter.close();
    }
}
