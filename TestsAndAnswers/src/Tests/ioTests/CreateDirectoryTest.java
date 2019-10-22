package Tests.ioTests;

import java.io.File;

public class CreateDirectoryTest {
    private static final String DIRECTORY_PATH = "D:TestFolder/NewFolder";
    public static void main(String[] args) {
        File newFolder = new File(DIRECTORY_PATH);
        if (!newFolder.exists()) {
            boolean isCreated = newFolder.mkdir();
            if (isCreated) {
                System.out.println("Folder successfully created");
            } else {
                System.out.println("failure");
            }
        } else {
            System.out.println("a folder already exists");
        }
    }
}
