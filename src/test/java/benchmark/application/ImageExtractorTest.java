package benchmark.application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class ImageExtractorTest {

    @Test
    void pullAllLastModifiedValidPath() throws IOException {
        // Creates a temp directory with 1 file to run this test
        Path tempDir = Files.createTempDirectory("validPath");
        Files.createFile(tempDir.resolve("testfile.txt"));

        ImageExtractor ie = new ImageExtractor();
        ie.setImagesPath(tempDir.toString());

        assertFalse(ie.pullAllLastModified().isEmpty(), "The list should not be empty for a valid directory with files.");
    }

    @Test
    void pullAllLastModifiedInvalidPath() {
        ImageExtractor ie = new ImageExtractor();
        ie.setImagesPath("invalid\\path\\that\\does\\not\\exist");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ie.pullAllLastModified();
        });

        assertEquals("Error: The directory doesn't exist or is not valid.", exception.getMessage());
    }

    @Test
    void pullAllLastModifiedNoFilesFound() throws IOException {
        ImageExtractor ie = new ImageExtractor();
        // Creates a temp directory without files to run this test
        Path tempDir = Files.createTempDirectory("validPath");
        ie.setImagesPath(tempDir.toString());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ie.pullAllLastModified();
        });
        
        assertEquals("No files found in the directory.", exception.getMessage());
    }


    @Test
    void pullAllSizeValidPath() throws IOException {
        // Creates a temp directory with 1 file to run this test
        Path tempDir = Files.createTempDirectory("validPath");
        Files.createFile(tempDir.resolve("testfile.txt"));

        ImageExtractor ie = new ImageExtractor();
        ie.setImagesPath(tempDir.toString());

        assertFalse(ie.pullAllSize().isEmpty(), "The list should not be empty for a valid directory with files.");
    }

    @Test
    void pullAllSizeInvalidPath() {
        ImageExtractor ie = new ImageExtractor();
        ie.setImagesPath("invalid\\path\\that\\does\\not\\exist");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ie.pullAllSize();
        });

        assertEquals("Error: The directory doesn't exist or is not valid.", exception.getMessage());
    }

    @Test
    void pullAllSizeNoFilesFound() throws IOException {
        ImageExtractor ie = new ImageExtractor();
        // Creates a temp directory without files to run this test
        Path tempDir2 = Files.createTempDirectory("validPath");
        ie.setImagesPath(tempDir2.toString());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ie.pullAllSize();
        });
        
        assertEquals("No files found in the directory.", exception.getMessage());
    }
}