package lab9.num2;

public class Quadrilateral extends Polygon{
    public Quadrilateral(int[] sides) {
        super(sides);
        if (sides.length != 4){
            throw new IllegalArgumentException("Invalid value. Try again");
        }

    }
    public static boolean isQuadrilateral(int[] sides){
        return ((!Rhombus.isRhombus(sides) && !Parallelogram.isParallelogram(sides)) && sides.length == 4);
    }
}
