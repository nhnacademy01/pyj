public class Continue {
    public static void main(String[] args) {
        Continue c = new Continue();
        c.continueAndFor();

    }

    private void continueAndFor() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 1) {
                continue;
            }
            System.out.println(i);
        }
    }
}
