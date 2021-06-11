package manager;

import file.FileFinder;
import file.FileReader;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Manager {
    public void run() {
        List<File> markdownFiles = getMarkdownFiles();

        for (File file : markdownFiles) {
            FileReader fileReader = new FileReader(file.getPath());
            String text = fileReader.read();
        }
    }

    private List<File> getMarkdownFiles() {
        Path resourcePath = Paths.get("./src/main/resources");
        FileFinder fileFinder = new FileFinder(resourcePath);
        List<File> markdownFiles = fileFinder.findAll(".md");
        return markdownFiles;
    }
}
