import file.FileFinder;
import file.FileReader;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import manager.Manager;

public class Application {

    public static void main(String[] args) {
        new Manager().run();
    }
}
