package game;

public interface Monster{


    public String getId();

    public int getLevel();

    public int getHp();

    public int attack();

    public int attacked(int attackGage);
}

