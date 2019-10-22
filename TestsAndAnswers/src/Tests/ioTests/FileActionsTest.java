package Tests.ioTests;

import java.io.File;

public class FileActionsTest {

    public static void main(String[] args) {
        //create dir
        File dir = new File("D://newDir");
        boolean createDir = dir.mkdir();
        if (createDir){
            System.out.println("newDir has been created");
        }
        //renameDir
        File newDir = new File("D://newDirRenamed");
        boolean renameDir = dir.renameTo(newDir);
        if (renameDir){
            System.out.println("newDir has been renamed");
        }
        //delete dir
        boolean deleteDir = newDir.delete();
        if (deleteDir){
            System.out.println("end");
        }
    }
}
