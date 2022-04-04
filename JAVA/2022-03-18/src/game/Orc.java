package game;

import javax.management.modelmbean.ModelMBeanAttributeInfo;

public class Orc extends Monster {

    public Orc() {
        super("오크", "야생" , 2, 40);
    }

    @Override
    public int attack() {
        return super.random.nextInt(6)+1;
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
