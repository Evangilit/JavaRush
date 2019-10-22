package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception{
        Solution s = new Solution("D:TestFolder/file.txt");
        s.writeObject("kykaracha");
        s.close();
        FileOutputStream fos = new FileOutputStream("D:TestFolder/file1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        s.writeObject(oos);
        oos.close();
        fos.close();
        FileInputStream fis = new FileInputStream("D:TestFolder/file1.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s.readObject(ois);
        ois.close();
        fis.close();
        s.writeObject("Ebanko");

    }
}
