package Tests;

import java.io.Serializable;
import java.lang.reflect.Field;

public class ClassTest {

    public static final int I = 13;

    public static void main(String[] args) {

//        Class[] interfaces = GetInterfacesClass.class.getInterfaces();
//        for (int i = 0; i < interfaces.length; i++) {
//            System.out.println(interfaces[i].getName());
//        }
//        try {
//            Field intField;
//            intField.setAccessible(true);
//            intField.set(I, 15);
//            System.out.println(I);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }

    public static class GetInterfacesClass implements Serializable, AutoCloseable{
        @Override
        public void close() throws Exception {
        }
    }
}
