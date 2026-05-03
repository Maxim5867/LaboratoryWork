package lab10.num2.Armor;

public class Helmet extends BaseArmor{
    private int HELMET_POSITION = 3;

    public Helmet(int durability) {
        super(durability);
    }

    public int getPosition(){
        return HELMET_POSITION;
    }
}
