import java.util.Scanner;

public class N3 {
    public static void main(String[] args) {
        Scanner consolscanner = new Scanner(System.in);
        System.out.print("Во сколько вы выехали\n-> ");
        String input = consolscanner.nextLine();

        if (Integer.parseInt(input.split(":")[0])<24 && Integer.parseInt(input.split(":")[1])<60 && Integer.parseInt(input.split(":")[0])>=0 && Integer.parseInt(input.split(":")[1])>=0){
            int startTime = Integer.parseInt(input.split(":")[0])*60+Integer.parseInt(input.split(":")[1]);
            System.out.print("Введите сколько времени будет длиться путь\n-> ");
            int driveTime = Integer.parseInt(consolscanner.nextLine());

            if (driveTime<=1440 && driveTime>0) {
                int endTime = startTime + driveTime;
                if (endTime >= 1440) {
                    endTime -= 1440;
                }
                System.out.printf("Время приезда %02d:%02d", endTime / 60, endTime % 60);
            }else {
                System.out.println("Неправильный ввод");
            }
        }else {
            System.out.println("Неправильный ввод");
        }
        }
    }


