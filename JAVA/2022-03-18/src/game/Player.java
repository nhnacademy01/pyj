package game;

import java.util.Random;

public class Player implements Worrier, PlayerAct{
    Random random = new java.security.SecureRandom();

    private String id = "yj";
    private int level = 1;
    private int hp = 100;
    private int attack = 150;
    private int stageLevel = 0;

    public static final int MAX_LEVEL = 4;

    @Override
    public void enterDungeon() {

    }

    @Override
    public void levelUp() {

    }

    @Override
    public void recover() {

    }

    @Override
    public void upgradeHp() {

    }

    @Override
    public void upgradeAttack() {

    }

    @Override
    public int attack() {
        return random.nextInt(10)+1;
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

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getStageLevel() {
        return stageLevel;
    }
}
