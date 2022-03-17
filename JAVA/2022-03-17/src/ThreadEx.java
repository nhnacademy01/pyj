public class ThreadEx {

    public static Object object1 = new Object();
    public static Object object2 = new Object();

    public static void main(String[] args) {
        FirstThread thread1 = new FirstThread();
        SecondThread thread2 = new SecondThread();

        thread1.start();
        thread2.start();

    }

    private static class FirstThread extends Thread{
        @Override
        public void run() {
            synchronized (object1){
                System.out.println("First Thread has object1's lock");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("First Thread want to have object2's lock. so wait");

                synchronized (object2){
                    System.out.println("First Thread has object2's lock too");
                }
            }
        }
    }

    private static class SecondThread extends Thread{
        @Override
        public void run() {
            synchronized (object2){
                System.out.println("Second Thread has object2's lock");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Second Thread want to have object1's lock, so wait");

                synchronized (object1){
                    System.out.println("Second Thread has object1's lock too");
                }
            }
        }
    }
}