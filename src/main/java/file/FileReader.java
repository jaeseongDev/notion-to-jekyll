package file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    private final Path path;

    public FileReader(File file) {
        this(Path.of(file.getAbsolutePath()));
    }

    public FileReader(String path) {
        this(Path.of(path));
    }

    public FileReader(Path path) {
        this.path = path;
    }

    public String read() {
        try {
            byte[] readingBytes = Files.readAllBytes(path);
            return new String(readingBytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
