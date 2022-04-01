package game;

public class Dragons extends Monsters {
    public final static int ATTACK_GAGE = 10;


    // 공격을 하는 함수
    public int attack() {
        return randoms.nextInt(ATTACK_GAGE) + 1;
    }

    // 공격을 받는 함수
    public void attacked(int sum) {
        // 방어력이 받은 데미지보다 큰 경우
        if (defense >= sum)
            hp = hp - 0;
        else
            hp = hp + defense - sum;
    }
}
