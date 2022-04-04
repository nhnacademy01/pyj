import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

//        try {
//            in = new FileInputStream("source.txt");
//            out = new FileOutputStream("replica.txt");
//            // 버퍼가 없고 4byte로 읽어서 사용하기 때문에 성능이 안좋다
//            // 버퍼를 이용해서 파일 input, output 하는 것이 좋다
//            int c;
//
//            while ((c = in.read()) != -1) {
//                out.write(c);
//            }
//        } finally {
//            if (in != null) {
//                in.close();
//                // jvm에서 알아서 닫아주기는 하지만 (GC)
//                // 닫아주는게 좋다
//                // 왜냐면,, 한 파일에 대해서 여러번 접근하는 경우가 있기도 때문에
//                // 재깍재깍 닫아주는게 좋다리 ~
//            }
//            if (out != null) {
//                out.close();
//            }
//        }

        // try - resource - finally 가 편하다
        try (
                FileInputStream in2 = new FileInputStream("source.txt");
                FileOutputStream out2 = new FileOutputStream("replica2.txt");
        ) {
            int c;

            while ((c = in2.read()) != -1) {  // 파일을 읽을 수 없을 때 -1 (EOF)
                out2.write(c);
            }
        }
    }
}