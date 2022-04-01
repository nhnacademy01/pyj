package game;

public class Dragon extends Monster {

    private int attackGage = 10;


    public Dragon() {
        super("드래곤", "*보스*", 3, 100);
    }

    @Override
    public int attack() {
        return super.random.nextInt(10)+1;
    }

    @Override
    public void runAway() {

    }

    @Override
    public void decreaseHp() {

    }

    @Override
    public void checkHp() {

    }

    @Override
    public void win() {

    }

    @Override
    public void lose() {

    }
}
