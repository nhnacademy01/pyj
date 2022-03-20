package game;

public class Dragon extends Character implements Monster {
    private final static String BASIC_ID = "드래곤";
    private final static String BASIC_STATE = "*보스* ";
    private final static int BASIC_LEVEL = 3;
    private final static int BASIC_HP = 100;
    private final static int ATTACK_GAGE = 10;


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
        if(randoms.nextInt(10) == 0){
            return breath();
        }
        return (randoms.nextInt(ATTACK_GAGE) + 1);
    }

    public int breath(){
        return (15);
    }

    @Override
    public int attacked(int attackGage) {
        setHp((this.hp - attackGage));
        return (this.hp - attackGage);
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "hp=" + hp +
                '}';
    }
}
