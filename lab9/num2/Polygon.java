package lab9.num2;

public class Polygon {
    protected int[] sides;

    public Polygon(int[] sides) {
        // todo
        if (!isCorrectPolygon(sides) ){
            throw new IllegalArgumentException("Invalid value. Try again");
        }
        this.sides = sides;
    }

    public int getSidesCount() {
        return sides.length;
    }

    public int getPerimeter() {
        int p = 0;
        for (int side : sides) {
            p += side;
        }
        return p;
    }

    public static boolean isCorrectSide(int side){
        return side >= 1;
    }

    public static boolean isCorrectPolygon(int[] sides){
        int maxSide = Integer.MIN_VALUE;
        int sum = 0;
        if (sides.length >= 3) {
            for (int side : sides) {
                sum += side;
                if (side > maxSide) {
                    maxSide = side;
                }
            }
        }
        return maxSide < sum - maxSide;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (Circle.isCircle(sides)){
            sb.append("Circle radius is ").append(sides[0]);
            sb.append(System.lineSeparator());
            sb.append("Its perimeter is ").append(sides[0]);
            sb.append(System.lineSeparator());
            sb.append("Its area is ").append(Math.PI * Math.pow(sides[0],2));
        }
        else if (EquilateralTriangle.isEquilateralTriangle(sides)){
            double p = (double) (sides[0] + sides[1] + sides[2]) / 2;
            sb.append("Equilateral triangle contains ").append(getSidesCount()).append(" equal sides");
            sb.append(System.lineSeparator());
            sb.append("Its perimeter is ").append(getPerimeter());
            sb.append(System.lineSeparator());
            sb.append("Its radius of in circle is ").append((Math.sqrt(((p-sides[0])*(p-sides[1])*(p-sides[2]))/p)));
        }
        else if (IsoscelesTriangle.isIsoscelesTriangle(sides)){
            double p = (double) (sides[0] + sides[1] + sides[2]) / 2;
            sb.append("Isosceles triangle contains pair of equal sides ");
            sb.append(System.lineSeparator());
            sb.append("Its perimeter is ").append(getPerimeter());
            sb.append(System.lineSeparator());
            sb.append("Its radius of in circle is ").append((Math.sqrt(((p-sides[0])*(p-sides[1])*(p-sides[2]))/p)));
        }
        else if (Triangle.isTriangle(sides)){
            double p = (double) (sides[0] + sides[1] + sides[2]) / 2;
            sb.append("Triangle contains ").append(getSidesCount()).append(" sides");
            sb.append(System.lineSeparator());
            sb.append("Its perimeter is ").append(getPerimeter());
            sb.append(System.lineSeparator());
            sb.append("Its radius of in circle is ").append((Math.sqrt(((p-sides[0])*(p-sides[1])*(p-sides[2]))/p)));
        }
        else if (Rhombus.isRhombus(sides)){
            sb.append("Rhombus contains ").append(getSidesCount()).append(" sides");
            sb.append(System.lineSeparator());
            sb.append("Its perimeter is ").append(getPerimeter());
        }
        else if (Parallelogram.isParallelogram(sides)){
            sb.append("Parallelogram contains two pairs of parallel sides ");
            sb.append(System.lineSeparator());
            sb.append("Its perimeter is ").append(getPerimeter());
        }
        else if (Quadrilateral.isQuadrilateral(sides)){
            sb.append("Quadrilateral contains ").append(getSidesCount()).append(" sides");
            sb.append(System.lineSeparator());
            sb.append("Its perimeter is ").append(getPerimeter());
        }
        else if (Polygon.isCorrectPolygon(sides)){
            sb.append("Polygon contains ").append(getSidesCount()).append(" sides");
            sb.append(System.lineSeparator());
            sb.append("Its perimeter is ").append(getPerimeter());
        }
        return sb.toString();
    }
}
