import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class FileExample {
    public static void main(String[] args) throws IOException {
        FileExample e = new FileExample();
//        e.write();
//        e.read();
//        e.access();
        e.randomAccess();
    }

    private void randomAccess() throws IOException {
        try (RandomAccessFile file = new RandomAccessFile("myfile.txt", "rw")) {
            // rw 싱크 걸어서 다른 프로세스가 접근 못하게 하는 것

            file.writeChar('S');                // 2
            file.writeInt(2222);                // 4
            file.writeDouble(222.22);           // 8
            file.writeInt(32243);               // 4
            file.writeBoolean(false);           // 1 byte
            System.out.println(file.length());

            file.seek(0);                     // 처음으로 이동
            System.out.println(file.readChar());
            System.out.println(file.readInt());
            System.out.println(file.readDouble());
            file.seek(2);
            System.out.println(file.readInt());
            file.seek(14);
            System.out.println(file.readInt());
        }
    }

    private void read() {
        Path filePath = Paths.get("output.txt");
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void write() throws IOException {
        Path path = Paths.get("output.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE)) {
            writer.write("Hello World !!");
            writer.write(System.lineSeparator());
        }
    }

    void access() throws IOException{
//        Path.of("User", "nhn").toFile();
        // 이런식으로 작성해야 이식성이 좋아진다

        File f = new File("C:\\Users\\park\\Desktop\\NHN\\NHN_SRC\\JAVA\\2022-03-18\\src\\FileExample.java");
        System.out.println("name: " + f.getName());
        System.out.println("path: " + f.getPath());
        System.out.println("absolute path: " + f.getAbsolutePath());
        System.out.println("canonical path: " + f.getCanonicalPath());
        System.out.println("parent: " + f.getParent());
        System.out.println("separator: " + File.separator);
    }
}