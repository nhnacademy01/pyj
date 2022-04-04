package game;

public class Slime extends Monster {
    private int attackGage;
    public Slime() {
        super("슬라임", "야생" , 1, 30);
    }


    @Override
    public int attack() {
        return super.random.nextInt(4)+1;
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
