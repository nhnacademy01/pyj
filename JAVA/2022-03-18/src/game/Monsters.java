package game;

public class Monsters extends Character{
    public int power;
    public int defense;
    public int money;
    public int experience;

    public int attack()
    {
        return power;
    }

    // 공격을 받는 함수
    public void attacked(int sum) {

        // 방어력이 받은 데미지보다 큰 경우
        if(defense >= sum)
            hp = hp - 0;
        else
            hp = hp + defense - sum;
    }
}

