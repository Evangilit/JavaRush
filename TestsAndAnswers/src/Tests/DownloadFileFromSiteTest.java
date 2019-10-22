package Tests;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DownloadFileFromSiteTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("");
            new File("D:TestFolder/NewFolder").mkdir();
            Path path = Paths.get("D:TestFolder/NewFolder");
            downloadMethod(url, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadMethod(URL url, Path target){
        try (InputStream in = url.openStream()) {
            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            System.out.println("Something Wrong");
        }
    }
}
