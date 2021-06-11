package file;

import static org.assertj.core.api.Assertions.assertThat;

import file.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileReaderTest {

    @Test
    @DisplayName("파일을 정상적으로 읽어들이는 지 체크")
    public void read() throws IOException {
        // given
        String writingText = "hello\ntest";
        byte[] writingBytes = writingText.getBytes();
        Path path = Paths.get("./src/main/resources/test.txt");
        Files.write(path, writingBytes);

        // when
        File file = new File(path.toString());
        FileReader fileReader = new FileReader(path);
        String readingText = fileReader.read();

        // then
        assertThat(file.exists()).isTrue();
        assertThat(readingText).isEqualTo(writingText);
        file.delete();
    }
}
