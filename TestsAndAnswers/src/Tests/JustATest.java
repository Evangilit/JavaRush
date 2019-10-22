package Tests;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class JustATest {
    public static void main(String[] args) {

    }


    class Garbage implements Stuff{
        public Garbage(){
            strangeMethod();
        }

        @Override
        public void strangeMethod() {
            System.out.println("absolutely nothing");
        }
    }

    interface Stuff{
        void strangeMethod();
    }
}
