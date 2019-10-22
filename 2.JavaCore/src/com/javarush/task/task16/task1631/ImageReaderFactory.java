package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes type){
        try {
            switch (type){
                case BMP: return new BmpReader();
                case JPG: return new JpgReader();
                case PNG: return new PngReader();
                default: throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
