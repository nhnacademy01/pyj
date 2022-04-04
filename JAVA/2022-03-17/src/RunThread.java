public class RunThread {
    public static void main(String[] args) {
        System.out.println("Hello! Main on " + Thread.currentThread().getName());
        new HelloThread().start(); // 쓰레드 실행
        new Thread(new HelloRunner()).start();
        new HelloThread().start();
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        // 아래 함수들은 쓰레드가 시작되고 그 안에서 사용하는 메소드들임..
        System.out.println("Hello! Thread on " + Thread.currentThread().getName());
        System.out.println("helloThread.id: " + Thread.currentThread().getId());
        System.out.println("helloThread.priority: " + Thread.currentThread().getPriority());
        System.out.println("helloThread.isDaemon: " + Thread.currentThread().isDaemon());
    }
}

class HelloRunner implements Runnable {
    @Override
    public void run() {
        // 한번에 쭉쭉 찍히는 것이 아닌
        // 쓰레드 3개를 동시에 생성해서 찍히는 중

        System.out.println("Hello! Runner on " + Thread.currentThread().getName());
        System.out.println("helloRunner.id: " + Thread.currentThread().getId());
        System.out.println("helloRunner.priority: " + Thread.currentThread().getPriority());
        System.out.println("helloRunner.isDaemon: " + Thread.currentThread().isDaemon());
    }
}