import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamLine {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\park\\Desktop\\NHN\\NHN_SRC\\JAVA\\2022-03-18\\src");
        Stream<Path> fileStream = Files.list(path);

        fileStream.flatMap(StreamLine::getLines) // static 메서드인 경우 >{ClassName}::getLines()
                .forEach(System.out::println);
    }

    private static Stream<String> getLines(Path f) {
        try {
            return Files.lines(f);
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}