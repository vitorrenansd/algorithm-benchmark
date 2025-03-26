package benchmark.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ImageExtractor {

    // Method to get the last modified timestamps of files
    public void pullAllLastModified(String directoryName) {
        File directory = new File(directoryName);
        ArrayList<Long> lastModifiedList = new ArrayList<>();
    
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Error: The directory doesn't exist or is not valid.");
        }
    
        File[] files = directory.listFiles(File::isFile);

        if (files != null) {
            for (File file : files) {
                lastModifiedList.add(file.lastModified());
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }
    
    // Method to get the file sizes in bytes
    public void pullAllSize(String directoryName) {
        File directory = new File(directoryName);
    
        // Check if the directory exists and is valid
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Error: The directory doesn't exist or is not valid.");
        }

        // Get all files in the directory
        File[] files = directory.listFiles(File::isFile);
        ArrayList<Long> fileSizes = new ArrayList<>();
    
        if (files != null) {
            // Collect the file sizes of each file
            for (File file : files) {
                fileSizes.add(file.length()); // Returns file size in bytes
            }
    
            // Print the results automatically
            System.out.println("\nFile Sizes (bytes):");
            for (Long size : fileSizes) {
                System.out.println(size);
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }

    public void extractData(String imageName) {
        File image = new File ("images/" + imageName);

        // Format to Brazil default date-time
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
