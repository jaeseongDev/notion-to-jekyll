package file;

import java.io.File;

public class FileEditor {
    private final File file;

    public FileEditor(File file) {
        this.file = file;
    }

    public File editFileName(String newFileName) {
        File newFile = new File(file.getParent(), newFileName);
        if (file.renameTo(newFile)) {
            return newFile;
        }
        throw new IllegalArgumentException("파일 이름이 수정되지 않았습니다.");
    }
}
