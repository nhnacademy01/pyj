package game;

public class Hero extends Character {

    private final static int BASIC_HP = 100;
    private final static int BASIC_LEVEL = 1;
    private final static int BASIC_ATTACK_GAGE = 10;

    public String id;
    public int level = BASIC_LEVEL;
    public int hp = BASIC_HP;
    private int attackGage = BASIC_ATTACK_GAGE;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getState() {
        return null;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackGage() {
        return attackGage;
    }

    public int attack() {
        return randoms.nextInt(attackGage) + 1;
    }

    @Override
    public int attacked(int attackGage) {
        setHp((this.hp - attackGage));
        return getHp();
    }


    public void levelUp() {
        this.hp = (getHp() + 5);
        this.level = (getLevel() + 1);
        this.attackGage = (getAttackGage() + 5);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                '}';
    }
}

