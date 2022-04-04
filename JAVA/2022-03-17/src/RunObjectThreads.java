public class RunObjectThreads {
    public static void main(String[] args) {
        RunObjectThreads r = new RunObjectThreads();
        r.checkThreadState();
    }
    Object monitor = new Object();
    void checkThreadState() {
        MonitorThread t = new MonitorThread(monitor);
        // 모니터 쓰레드 생성만 함
//        MonitorThread t2 = new MonitorThread(monitor);    // 2
        try {
            System.out.println("t.state after new: " + t.getState());
            t.start();
            // t 시작
//            t2.start();   // 2
            System.out.println("t.state after start: " + t.getState());
            // t의 상태는 runnable로 바뀜
            Thread.sleep(100);
            System.out.println("t.state after 0.1 sec: " + t.getState());
            synchronized (monitor) {
                monitor.notify();   // monitor 에 의해 wait 중인 스레드(t)를 깨운다
                // 2 주석을 풀고 실행하면 - waiting 중인 스레드가 2개인데 둘 중 1개를 깨운다
                // monitor.notify();    // 3
                // monitor.notifyAll(); // 4
                // 안정성 측면에서 notifyAll()로 모두 깨우는게 좋다
            }
            Thread.sleep(100);
            System.out.println("t.state after notify: " + t.getState());
            t.join();   // 스레드 종료 시 까지 대기
            System.out.println("t.state after join: " + t.getState());
//            t2.join();    // 2
//            System.out.println("t2.state after join: " + t2.getState()); // 2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// timed waiting 은 내가 지정한 timeout 까지 대기중인 상태
// waiting 스레드가 대기중인 상태 (무한)