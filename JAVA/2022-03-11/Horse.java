public class Horse {
    private int power = 10;

    public void run() {
        power--;
        System.out.println("다가닥~ 다가닥~");
    }

    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.run();

        Unicorn unicorn = new Unicorn();
        unicorn.run();
        unicorn.doMagic();
    }
}

class Unicorn extends Horse {
    private int magicPower = 10;

    public void doMagic() {
        magicPower--;
        System.out.println("마법을 부립니다.");
    }
}