import java.util.Scanner;

public class N9 {
    public static void main(String[] args) {
        Scanner consolscanner = new Scanner(System.in);
        int N = 1;
        String center;
        String point;
        boolean index;
        boolean index1;
        do {
            System.out.print("Введите координаты центра окружности в формате x:y\n->");
            center = consolscanner.nextLine();
            index = center.contains(":");
            if (!index) {
                System.out.println("Неправильный ввод!");
            }
        } while (!index);
        do {
            System.out.print("Введите координаты точки окружности x:y\n->");
            point = consolscanner.nextLine();
            index1 = point.contains(":");
            if (!index1) {
                System.out.println("Неправильный ввод!");
            }
        } while (!index1);
        int x1 = Integer.parseInt(center.split(":")[0])*N;
        int y1 = Integer.parseInt(center.split(":")[1])*N;
        int x2 = Integer.parseInt(point.split(":")[0])*N;
        int y2 = Integer.parseInt(point.split(":")[1])*N;
        perimeter(x1,y1,x2,y2);
    }

    static void perimeter (int a, int b, int c, int d){
        double length = 2 * Math.PI * (Math.sqrt(Math.pow(c-a,2) + Math.pow(d-b,2)));
        System.out.printf("%.2f", length);

    }
}