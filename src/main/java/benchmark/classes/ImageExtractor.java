package benchmark.classes;

import java.io.File;
import java.text.SimpleDateFormat;

public class ImageExtractor {

    public void extractData(String imageName) {
        File image = new File ("src/main/java/benchmark/images/" + imageName);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        if (image.exists() && image.isFile()) {
            System.out.println("Name: " + image.getName());
            System.out.println("Path: " + image.getAbsolutePath());
            System.out.println("Size: " + image.length() + "bytes");
            System.out.println("Date: " + sdf.format(image.lastModified()));
        } else {
            throw new NullPointerException("This image does not exist or incorrect path");
        }
    }
}