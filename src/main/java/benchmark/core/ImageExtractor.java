package benchmark.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The ImageExtractor class is responsible for extracting file metadata
 * (such as last modified timestamp and file size) from a given directory 
 * that contains image files. The class provides methods to retrieve 
 * information about the files present in the specified directory.
 * 
 * <p>
 * Example usage:
 * <pre>
 *     ImageExtractor ex = new ImageExtractor();
 *     ex.setImagesPath("path/to/images");
 *     List<Long> lastModified = extractor.pullAllLastModified();
 *     List<Long> fileSizes = extractor.pullAllSize();
 * </pre>
 * </p>
 * 
 * @author vitorrenansd
 * @version 0.7.2-beta
 * @since 2025-04-14
 */
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
    
        if (files != null && files.length != 0) {
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
    
        if (files != null && files.length != 0) {
            for (File file : files) {
                fileSizeList.add(file.length()); // Returns file size in bytes
            }
        } else {
            throw new IllegalArgumentException("No files found in the directory.");
        }
        return fileSizeList;
    }
}