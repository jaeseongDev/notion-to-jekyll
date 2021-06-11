package file;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileEditorTest {

    @Test
    @DisplayName("파일 이름을 정상적으로 수정하는 지 체크")
    public void editFileName() throws IOException {
        // given
        String oldFileName = "old.txt";
        String newFileName = "new.txt";

        String writingText = "abcdefg";
        byte[] writingBytes = writingText.getBytes();
        Path path = Path.of("./src/main/resources/" + oldFileName);
        Files.write(path, writingBytes);

        // when
        File oldFile = new File(path.toString());
        FileEditor fileEditor = new FileEditor(oldFile);
        File newFile = fileEditor.editFileName(newFileName);

        // then
        assertThat(oldFile.exists()).isFalse();
        assertThat(newFile.getName()).isEqualTo(newFileName);
    }

}
