package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileFinder {
    private final Path basePath;

    public FileFinder(Path basePath) {
        this.basePath = basePath;
    }

    public List<File> findAll(String endOfFileName) {
        try {
            return Files.walk(basePath)
                .filter(path -> path.toString().endsWith(endOfFileName))
                .map(path -> new File(path.toString()))
                .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("IOException 에러 발생");
        }
    }
}
