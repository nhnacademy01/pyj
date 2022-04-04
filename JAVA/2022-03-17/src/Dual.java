public class Dual {
    public static void main(String[] args) {
        Dual dual = new Dual();
        dual.humanVsOrc();
    }

    private StringBuilder sb = new StringBuilder();

//    StringBuffer sb = new StringBuffer();

    /*synchronized*/ void attack(String weapon) {
//        synchronized (this) {
//            sb.append(weapon);
//        }
        sb.append(weapon);
        // 싱크로 ㄴ ㅏ이즈드  하나 줄세워야 그제야 접근할 수 있음
        // 너 들어가
        // 너 다 했니?
        // 이제 나 갈게.. 이런 느낌
    }

    public void humanVsOrc() {
        Thread human = new Thread(new Worrier("🗡️️", this));
        Thread orc = new Thread(new Worrier("🪓", this));

        orc.start();
        human.start();

        try {
            orc.join();     // 스레드가 종료될 때까지 대기
            human.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

    static class Worrier implements Runnable {
        private static Object lock = new Object();
        private String weapon;
        private Dual dual;

        public Worrier(String weapon, Dual dual) {
            this.weapon = weapon;
            this.dual = dual;
        }

        @Override
        public void run() {
            for (int i = 0; i < 400; i++) {
                attack();
            }
        }

        public void attack() {
//            dual.attack(this.weapon);
            synchronized (lock){
                dual.attack(this.weapon);
            }
        }
    }
}