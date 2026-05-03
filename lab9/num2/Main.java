package lab9.num2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Polygon g = new Polygon(new int[]{1,-1,1,1,-1});
        System.out.println(g.getPerimeter());
        Scanner consolscanner = new Scanner(System.in);

        String[] array = (consolscanner.nextLine().strip()).replaceAll("  ", " ").split(" ");

        try {
            int len = array.length;
            int[] sides = new int[len];
            for (int i = 0; i < len; i++) {
                sides[i] = Integer.parseInt(array[i]);
            }
            Polygon figure = createFigure(sides);
            if (figure == null){
                System.out.println("Invalid value. Try again");
            }
            else System.out.println(figure);
        } catch (NumberFormatException e){
            System.out.println("Invalid value. Try again");
        }
    }
        //check what figure we create
    public static Polygon createFigure(int[] sides) {
        if (sides.length == 3  && Polygon.isCorrectPolygon(sides)) {
            for (int side : sides){
                if (!Polygon.isCorrectSide(side)){
                    return null;
                }
            }
            if (EquilateralTriangle.isEquilateralTriangle(sides)) {
                return new EquilateralTriangle(sides);
            } else if (IsoscelesTriangle.isIsoscelesTriangle(sides)) {
                return new IsoscelesTriangle(sides);
            } else if (Triangle.isTriangle(sides)) {
                return new Triangle(sides);
            }
        }

        if (sides.length == 4 && Polygon.isCorrectPolygon(sides)) {
            for (int side : sides){
                if (!Polygon.isCorrectSide(side)){
                    return null;
                }
            }
            if (Rhombus.isRhombus(sides)) {
                return new Rhombus(sides);
            } else if (Parallelogram.isParallelogram(sides)) {
                return new Parallelogram(sides);
            } else if (Quadrilateral.isQuadrilateral(sides)) {
                return new Quadrilateral(sides);
            }
        }

        if (sides.length == 1) {
            for (int side : sides){
                if (!Polygon.isCorrectSide(side)){
                    return null;
                }
            }
            if (Circle.isCircle(sides)) {
                return new Circle(sides[0]);
            }
        }

        if (sides.length >= 5  && Polygon.isCorrectPolygon(sides)) {
            for (int side : sides){
                if (!Polygon.isCorrectSide(side)){
                    return null;
                }
            }
            if (Polygon.isCorrectPolygon(sides)) {
                return new Polygon(sides);
            }
        }
        return null;
    }
}
