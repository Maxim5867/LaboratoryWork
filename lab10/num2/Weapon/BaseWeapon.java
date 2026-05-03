package lab10.num2.Weapon;

public abstract class BaseWeapon implements Weapon{
    protected double power;

    public BaseWeapon(double power) {
        if (power < MIN_VALUE || power > MAX_VALUE){
            throw new IllegalArgumentException("Invalid power. Try again");
        }
        this.power = power;
    }

    @Override
    public double getPower() {
        return power;
    }

    public abstract int getDistance();

    @Override
    public String toString() {
        return (getClass().getSimpleName() + ", power: " + power + ", distance: " + (getDistance() + 1));
    }
}
