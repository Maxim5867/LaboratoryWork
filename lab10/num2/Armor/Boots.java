package lab10.num2.Armor;

public class Boots extends BaseArmor{
    private int BOOTS_POSITION = 1;

    public Boots(int durability) {
        super(durability);
    }


    public int getPosition(){
        return BOOTS_POSITION;
    }
}
