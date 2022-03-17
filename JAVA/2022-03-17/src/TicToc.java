public class TicToc {
    public static void main(String[] args) {
        TicToc ticToc = new TicToc();
//        ticToc.singleThreadTicToc();

        ticToc.multi();
    }

    void singleThreadTicToc() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print("Tick ");
            } else {
                System.out.print("Tock ");
            }
            try {
                Thread.sleep(1000);     // 1초 동안 잠들어요
            } catch (InterruptedException e) {
            }
        }
    }

    private void multi() {
        Thread tock = new Thread(new Tock());
        Thread tick = new Thread(new Tick());

        tick.start();
        tock.start();
    }

    class Tick implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.print("Tick ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    class Tock implements Runnable {
        @Override
        public void run() {
            // TODO 직접 구현해주세요.
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            for (int i = 0; i < 5; i++) {
                System.out.print("Tock ");
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){

                }

            }
        }
    }


}
