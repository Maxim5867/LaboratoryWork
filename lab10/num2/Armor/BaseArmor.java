package lab10.num2.Armor;

public abstract class BaseArmor implements Armor{
    protected int durability;

    public BaseArmor(int durability) {
        if (durability < MIN_VALUE || durability > MAX_VALUE){
            throw new IllegalArgumentException("Durability only 5 to 50");
        }
        this.durability = durability;
    }

    public boolean isBroken(){
        return durability <= 0;
    }

    public int protect(int damage){
        int absorbedDamage = 0;
        if (isBroken()) {
            return 0;
        } else {
            if (damage <= durability) {
                absorbedDamage = damage;
                durability -= damage;
            } else {
                absorbedDamage = durability;
                durability = 0;
            }
        }
        return absorbedDamage;
    }

    public abstract int getPosition();

    public String toString(){
        return (getPosition() + ": " + getClass().getSimpleName() + ", " + "durability: " + durability + ", " + "isBroken " + isBroken());
    }
}
