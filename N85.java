import java.util.Scanner;

public class N85 {
    public static void main(String[] args) {
        String input;
        double percent = 0;
        int debt = 0;
        int payment;
        int currentMonthNum=0;
        int stage = 1;
        Scanner consolscanner = new Scanner(System.in);
        for (;;) {
            switch (stage) {
                case 1 -> System.out.print("Введи процент\n>>>");
                case 2 -> System.out.print("Введи стоимость жилья\n>>>");
                default -> System.out.print("Введи платёж за " + (currentMonthNum) + " месяц\n>>>");
            }
            input = consolscanner.nextLine();
            if (!input.equalsIgnoreCase("stop")) {
                if (input.charAt(input.length()-1) == '%' && stage != 1) {
                    System.out.println("ignored");
                    continue;
                }
                switch (stage) {
                    case 1:
                        if (input.charAt(input.length()-1) == '%') {
                            percent = (Double.parseDouble(input.replace("%","")) / 100) + 1;
                            if (percent > 0) {
                                stage = 2;
                            } else {
                                System.out.println("wrong enter");
                            }
                        } else {
                            System.out.println("wrong enter");
                        }
                        break;
                    case 2:
                        if (Integer.parseInt(input) > 0) {
                            debt += Integer.parseInt(input);
                            currentMonthNum = 1;
                            stage = 3;
                            break;
                        }
                        System.out.println("wrong enter");
                        break;
                    default:
                        payment = Integer.parseInt(input);
                        if (payment > 0) {
                            currentMonthNum += 1;
                            if (payment < debt) {
                                debt = (int) Math.ceil((debt - payment) * percent);
                            } else { debt = debt - payment; }
                        } else {
                            System.out.println("wrong enter");
                        }
                }
                if (debt <= 0 && currentMonthNum != 0) {
                    System.out.println("Home! Sweet Home");
                    currentMonthNum = 0;
                    stage = 1;
                }

            } else {
                if (debt < 0) {
                    System.out.println("Deposit amount " + Math.abs(debt));
                } else {
                    System.out.println("Debt amount " + debt);
                }
            }
        }
    }
}
