public class SumAvg {
    public static void main(String[] args) {
        int sum = 0;
        float avg;

        int[] scores = {90, 75, 62, 80, 100};

        for(int i=0; i<scores.length; i++){
            sum += scores[i];
        }
        avg = (float) sum / scores.length;

        System.out.println("sum = "+sum);
        System.out.println("avg = "+avg);
    }
}
