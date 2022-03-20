package game;

public class Orc extends Character implements  Monster{
    private final static String BASIC_ID = "오크";
    private final static String BASIC_STATE = "야생의 ";
    private final static int BASIC_LEVEL = 2;
    private final static int BASIC_HP = 40;
    private final static int ATTACK_GAGE = 6;

    public int hp = BASIC_HP;

    @Override
    public String getId() {
        return BASIC_ID;
    }

    @Override
    public String getState() {
        return BASIC_STATE;
    }

    @Override
    public int getLevel() {
        return BASIC_LEVEL;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    @Override
    public int attack() {
        return (randoms.nextInt(ATTACK_GAGE) + 1);
    }

    @Override
    public int attacked(int attackGage) {
        setHp((this.hp - attackGage));
        return (this.hp - attackGage);
    }

    @Override
    public String toString() {
        return "Orc{" +
                "hp=" + hp +
                '}';
    }
}
