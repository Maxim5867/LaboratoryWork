package lab9.num2;

public class Rhombus extends Parallelogram{
    public Rhombus(int[] sides) {
        super(sides);
        if (sides.length != 4){
            throw new IllegalArgumentException("Invalid value. Try again");
        }

    }
    public static boolean isRhombus(int[] sides){
        return (sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3]);
    }
}
