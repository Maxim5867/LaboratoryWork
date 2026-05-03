package lab9.num2;

public class EquilateralTriangle extends IsoscelesTriangle{
    public EquilateralTriangle(int[] sides) {
        super(sides);
        if (sides.length != 3){
            throw new IllegalArgumentException("Invalid value. Try again");
        }

    }

    public static boolean isEquilateralTriangle(int[] sides){
        return  ((sides[0] == sides[1]) && (sides[1] == sides[2]) && sides.length == 3);
    }
}
