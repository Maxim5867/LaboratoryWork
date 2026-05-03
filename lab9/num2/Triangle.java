package lab9.num2;

public class Triangle extends Polygon{
    public Triangle(int[] sides) {
        super(sides);
        if (sides.length != 3){
            throw new IllegalArgumentException("Invalid value. Try again");
        }

    }

    public double getInRadius(){
        double p = (double) (sides[0] + sides[1] + sides[2]) / 2;
        return (Math.sqrt(((p-sides[0])*(p-sides[1])*(p-sides[2]))/p));
    }

    public static boolean isTriangle(int[] sides){
        return (sides[0] != sides[1] && sides[1] != sides[2] && sides[2] != sides[0] && sides.length == 3);
    }
}
