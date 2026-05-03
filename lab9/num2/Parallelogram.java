package lab9.num2;

public class Parallelogram extends Quadrilateral{
    public Parallelogram(int[] sides) {
        super(sides);
        if (sides.length != 4){
            throw new IllegalArgumentException("Invalid value. Try again");
        }

    }
    public static boolean isParallelogram(int[] sides){
        return (sides[0] == sides[2] && sides[1] == sides[3]);
    }
}
