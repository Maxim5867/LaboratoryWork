package lab9.num2;

public class IsoscelesTriangle extends Triangle{
    public IsoscelesTriangle(int[] sides) {
        super(sides);
        if (sides.length != 3){
            throw new IllegalArgumentException("Invalid value. Try again");
        }

    }
    public static boolean isIsoscelesTriangle(int[] sides){
        return ((sides[0] == sides[1] || sides[0] == sides[2] || sides[1] == sides[2]) && sides.length == 3);
    }
}
