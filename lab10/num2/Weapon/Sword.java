package lab10.num2.Weapon;

public class Sword extends BaseWeapon{
    private int SWORD_DISTANCE = 2;

    public Sword(double power) {
        super(power);
    }

    public int getDistance(){
        return SWORD_DISTANCE;
    }
}
