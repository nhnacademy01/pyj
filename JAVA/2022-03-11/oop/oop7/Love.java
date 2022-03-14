package oop.oop7;

public class Love{
    private static int POWER_OF_LOVE =Integer.MAX_VALUE;
    String fiance;

    Love(String fiance){
        this.fiance = fiance;
    }

    int powerOfLove(){
        return Love.POWER_OF_LOVE;
    }

    void transfer(final String newFiance){
        this.fiance = newFiance;
        POWER_OF_LOVE = 0;
    }
}

class Jealousy extends Love{

    Jealousy(String fiance){
        super(fiance);
    }

    @Override
    int powerOfLove(){
        return Integer.MAX_VALUE;
    }

}