package lab9.num1;

public class Boat extends Vehicle {
    private int oarsCount;

    public Boat(int oarsCount, int passengers) {
        super(passengers);
        this.setOarsCount(oarsCount);
    }

    private void setOarsCount(int oarsCount) {
        if (oarsCount < 0){
            throw new Error("Invalid negative number ! Argument: oars count");
        }
        else if (oarsCount == 0){
            throw new Error("Need oars to swim");
        }
        else
            if (oarsCount == super.passengers*2) {
                this.oarsCount = oarsCount;
            } else throw new Error("One too many oars!");
    }

    @Override
    public String toString() {
        return "In a Boat " + super.passengers + " passengers\n" +
                "With " + oarsCount + " oars";
    }
}
