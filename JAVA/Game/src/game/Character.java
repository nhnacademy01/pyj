package game;

import java.util.Random;

public abstract class Character {
    Random randoms = new java.security.SecureRandom();

    public abstract int attack();

    public abstract int attacked(int attackGage);

    public abstract int getHp();

    public abstract String getId();

    public abstract String getState();


}
