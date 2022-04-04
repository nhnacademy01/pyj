import java.util.Random;

public class DotArt {
    public static void main(String[] args) {
        final int size = 40;
        boolean[][] canvas = new boolean[size][size];
        Random random = new Random();
        for(int i=0; i<canvas.length; i++){
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = random.nextBoolean();
            }
        }

        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j] ? "*" : " ");
            }
            System.out.println();
        }
    }

}
