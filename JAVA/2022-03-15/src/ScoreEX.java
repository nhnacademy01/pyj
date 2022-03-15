import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScoreEX {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\park\\Desktop\\score.txt"));

        int i = 0;
        while (sc.hasNextLine()) {
            i++;
            String line = sc.nextLine();
            if (i == 1) {
                System.out.println(line + ",평균");
                continue;
            }
            // 구분자를 기준으로 하는 Scanner 생성
            Scanner rowSc = new Scanner(line).useDelimiter(",");
            int sum = 0;
            int avg = 0;
            int count = 0;
            while (rowSc.hasNextInt()) {
                sum += rowSc.nextInt();
                count++;
            }
            avg = sum / count;
            System.out.printf("%s,%d%n", line, avg);
        }
    }
}
