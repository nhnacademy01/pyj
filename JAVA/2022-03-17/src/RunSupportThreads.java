public class RunSupportThreads {
    public static void main(String[] args) {
        RunSupportThreads o = new RunSupportThreads();
//        o.checkThreadState1();
        o.checkThreadState2();
    }

    public void checkThreadState1() {
        SleepThread t = new SleepThread(2_000);  // 2초 동안 대기하는 스레드
        try {
            System.out.println("After new: " + t.getState());
            t.start();  // 스레드 시작
            System.out.println("After start: " + t.getState());
            Thread.sleep(1_000);    // 스레드 Sleep 중
            System.out.println("After 1 seconds: " + t.getState());
            t.join();   // 스레드 종료 대기
//            t.interrupt();    // 스레드 중지 요청
//            t.join(500);    // 0.5초 동안 스레드 종료 대기
            System.out.println("After join: " + t.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Object monitor = new Object();

    void checkThreadState2() {
        MonitorThread t = new MonitorThread(monitor);
        MonitorThread t2 = new MonitorThread(monitor);    // 2
        try {
            System.out.println("t.state after new: " + t.getState());
            t.start();
            t2.start();   // 2
            System.out.println("t.state after start: " + t.getState());
            Thread.sleep(100);
            System.out.println("t.state after 0.1 sec: " + t.getState());
            synchronized (monitor) {
                monitor.notify();   // monitor 에 의해 wait 중인 스레드(t)를 깨운다
                monitor.notify();    // 3
                monitor.notifyAll(); // 4
            }
            Thread.sleep(100);
            System.out.println("t.state after notify: " + t.getState());
            t.join();   // 스레드 종료 시 까지 대기
            System.out.println("t.state after join: " + t.getState());
            t2.join();    // 2
            System.out.println("t2.state after join: " + t2.getState()); // 2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}