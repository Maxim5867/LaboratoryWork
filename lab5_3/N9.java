package lab5_3;
import java.util.Scanner;
public class N9 {
    public static void main(String[] args) {
        Scanner consolscanner = new Scanner(System.in);
        int N = 100;
        String center;
        String point;
        int index = 1;
        int indexx = 1;
        int indexy = 1;
        int index1 = 1;
        int index1x = 1;
        int index1y = 1;

        do {
            System.out.print("Введите координаты центра окружности в формате (x,y)\n->");
            center = consolscanner.nextLine();
            index = center.indexOf(",");
            indexx = center.indexOf("(");
            indexy = center.indexOf(")");
            if (index == -1 || indexx == -1 || indexy == -1) {
                System.out.println("Неправильный ввод!");
            }
        } while (index == -1 || indexx == -1 || indexy == -1);

        do {
            System.out.print("Введите координаты точки окружности (x,y)\n->");
            point = consolscanner.nextLine();
            index1 = point.indexOf(",");
            index1x = point.indexOf("(");
            index1y = point.indexOf(")");
            if (index1 == -1 || index1x == -1 || index1y == -1) {
                System.out.println("Неправильный ввод!");
            }
        } while (index1 == -1 || index1x == -1 || index1y == -1);

        String center1 = center.replace("(","").replace(")","");
        String point1 = point.replace("(","").replace(")","");
        int x1 = Integer.parseInt(center1.split(",")[0])*N;
        int y1 = Integer.parseInt(center1.split(",")[1])*N;
        int x2 = Integer.parseInt(point1.split(",")[0])*N;
        int y2 = Integer.parseInt(point1.split(",")[1])*N;
        System.out.printf("%.2f", perimeter(x1,y1,x2,y2));
    }

    static double perimeter (int a, int b, int c, int d){
        double length = 2 * Math.PI * (Math.sqrt(Math.pow(c-a,2) + Math.pow(d-b,2)));
        return length;

    }
}
