package game;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Monster implements Worrier{
//    Random random = new java.security.SecureRandom();

//    public enum ??{
//        ENEMY,
//        NEUTRAL,
//        ALLY
//    } //todo 할까말까

    private String id;
    private String state;
    private int level;
    private int hp;

    public Monster(String id, String state, int level, int hp) {
        this.id = id;
        this.state = state;
        this.level = level;
        this.hp = hp;
    }


    public String getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public int attack() {
        return 0;
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

    public void attacked() {
    }
}

