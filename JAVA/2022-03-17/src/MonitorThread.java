public class MonitorThread extends Thread {
    private Object monitor;

    public MonitorThread(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10_000; i++) {
                int sum = 1 + i;    // 실행 중 상태로 만드는 연산
            }
            System.out.println(getName() + " after running(10_000 times)");
            synchronized (monitor) {
                System.out.println(getName() + " is waiting");
                monitor.wait(); // 모니터에 의해 대기 중으로
            }
            System.out.println(getName() + " is notified");
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}