public class HomeWork4 {
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println("a: " + a + ", b : " + b);

        HomeWork4 types = new HomeWork4();
        types.swap(a,b);
    }

    public void swap(int a, int b){
        System.out.println("After swap. a: " + b + ", b: " + a);
    }
}
