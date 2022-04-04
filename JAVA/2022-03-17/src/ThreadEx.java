public class ThreadEx {
    public static Object object1 = new Object();
    public static Object object2 = new Object();

    public static void main(String[] args) {
        new Thread(new FirstThread()).start();
        new Thread(new SecondThread()).start();
        // object1, object2 둘 다 시작 !

    }

    private static class FirstThread implements Runnable{
        @Override
        public void run() {
            synchronized (object1){ // synchronized를 사용해서 한번에 한 쓰레드만 실행되게 할거야 (상호배제)
                System.out.println("thread1은 object1을 가지고 있는중");
                try {
                    Thread.sleep(10); // firstThread 10 밀리초 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } // firstThread sleep 끝
                System.out.println("thread1은 object2를 기다리는중");
                // (점유와 대기)
                // 왜냐하면 SecondThread에서는 object2를 계속 가지고 있기 때문(SecondThread 클래스에서도 synchronized 구문이 아직 안끝났다)
                // (비선점)
                // 다른 thread에서 가지고 있는 것을 강제로 가져오지 못한다

                synchronized (object2){ // object2를 가져와서 사용하려하지만, 15번째 라인의 synchronized가 끝나지 않아서 가져오지 못하는중 (환형대기)
                    System.out.println("thread1은 object1 + object2를 가지고 있는중 ");
                }
            }
        }
    }

    private static class SecondThread implements Runnable{
        @Override
        public void run() {
            synchronized (object2){
                System.out.println("thread2은 object2을 가지고 있는중");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2은 object1를 기다리는중");

                synchronized (object1){
                    System.out.println("thread2은 object1 + object2를 가지고 있는중");
                }
            }
        }
    }
}