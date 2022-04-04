package game;

public class Hero extends Character {
    // 캐릭터 중에서 영웅은 공통적으로 힘, 방어력, 돈, 경험치라는 변수를 가지고 있다.
    public int stageLevel = 0;
    public int attackGage = 10;

    // 공격을 하는 함수
    public int attack() {
        return randoms.nextInt(attackGage) + 1;
    }


    public void attacked(int sum) {

//        return (hp - sum)
//        // 방어력이 받은 데미지보다 큰 경우
//        if (hp >= sum)
//            hp = hp - ;
//        else
//            hp = hp + defense - sum;

    }

    public void levelUp() {

    }


    public void recover() {

    }

    public void upgradeHp() {

    }

    public void upgradeAttack() {

    }

    public void runAway() {

    }

    public void checkHp() {

    }

    public void win() {

    }

    public void lose() {

    }
}
