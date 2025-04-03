package benchmark.application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageExtractor {
    private String imagesPath;


    public void setImagesPath(String imagesPath) {
        this.imagesPath = imagesPath;
    }
    public String getImagesPath() {
        return imagesPath;
    }

    // Method to get the last modified timestamps of files
    public List<Long> pullAllLastModified() {
        File directory = new File(this.imagesPath);
    
        // Check if the directory exists and is valid
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Error: The directory doesn't exist or is not valid.");
        }
    
        // Get all files in the directory
        File[] files = directory.listFiles(File::isFile);
        List<Long> lastModifiedList = new ArrayList<>();
    
        if (files != null) {
            for (File file : files) {
                lastModifiedList.add(file.lastModified());
            }
        } else {
            throw new IllegalArgumentException("No files found in the directory.");
        }
        return lastModifiedList;
    }
    
    // Method to get the size in bytes of files
    public List<Long> pullAllSize() {
        File directory = new File(this.imagesPath);
    
        // Check if the directory exists and is valid
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Error: The directory doesn't exist or is not valid.");
        }

        // Get all files in the directory
        File[] files = directory.listFiles(File::isFile);
        List<Long> fileSizeList = new ArrayList<>();
    
        if (files != null) {
            for (File file : files) {
                fileSizeList.add(file.length()); // Returns file size in bytes
            }
        } else {
            throw new IllegalArgumentException("No files found in the directory.");
        }
        return fileSizeList;
    }
}