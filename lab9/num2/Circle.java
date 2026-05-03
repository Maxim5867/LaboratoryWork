package lab9.num2;

public class Circle extends Polygon{
    public Circle(int sides) {
        super(new int[]{sides});
    }

    public double getArea(){
        return Math.PI * Math.pow(sides[0],2);
    }

    public static boolean isCircle(int[] sides){
        return (sides.length == 1);
    }

}
