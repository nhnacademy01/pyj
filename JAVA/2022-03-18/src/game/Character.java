package game;

import java.util.Random;

public class Character {
    Random randoms = new java.security.SecureRandom();

    public String id;
    public int level;
    public int hp;
    private int stageLevel = 0;

    public int getStageLevel() {
        return stageLevel;
    }

    public void attack() {
    }
}
