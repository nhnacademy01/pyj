import java.util.StringTokenizer;

public class StringTokenizerEx {
    public static void main(String[] args) {
        String input = "50,20,,,40,30";
        // split
        String[] tokens = input.split(",");
        int countBySplit = tokens.length;
        System.out.println("countBySplit: " + countBySplit);
        System.out.println("tokensBySplit");
        for (String token : tokens) {
            System.out.printf("'%s' ", token);
        }
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(input, ",");
        int countBySt = st.countTokens();
        System.out.printf("%n%ncountBySt: %d%n", countBySt);
        System.out.println("tokensBySt");
        while (st.hasMoreTokens()) {
            System.out.printf("'%s' ", st.nextToken());
        }
    }
}
