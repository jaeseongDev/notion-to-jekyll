package file;

import static org.assertj.core.api.Assertions.assertThat;

import file.FileFinder;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileFinderTest {

    @Test
    @DisplayName("찾은 파일들이 markdown 확장자가 맞는 지 확인")
    public void findMarkdownFiles() {
        FileFinder fileFinder = new FileFinder(
            Paths.get("./src/main/resources"));
        List<File> files = fileFinder.findAll(".md");
        for (File file : files) {
            assertThat(file.getName()).endsWith(".md");
        }
    }
}