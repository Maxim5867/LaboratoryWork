package lab10.num2.Armor;

public class Dress extends BaseArmor {
    private int DRESS_POSITION = 2;

    public Dress(int durability) {
        super(durability);
    }

    public int getPosition(){
        return DRESS_POSITION;
    }
}
