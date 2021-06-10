import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    private final Path filePath;

    public FileReader(Path path) {
        this.filePath = path;
    }

    public String read() throws IOException {
        byte[] readingBytes = Files.readAllBytes(filePath);
        return new String(readingBytes, StandardCharsets.UTF_8);
    }
}
