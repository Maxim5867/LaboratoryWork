import Snake.Constants;

import java.lang.reflect.Array;
import java.util.*;

public class SnakeEasy {

    static boolean running = true;
    static String[][] map = new String[20][20];
    static String FOOD = "🍎";
    static String FIELD = "⬜";
    static String WALL = "🟥";
    static String HEAD = "🌳";
    static String BODY = "🟩";
    static ArrayList<int[]> positions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createMap();
        // СОЗДАНИЕ ПЕРВОНАЧАЛЬНОЙ ЗМЕЙКИ
        createFirstSnake();
        printMap();

        // ОБРАБОТКА ХОДА
        System.out.println("Введите, куда вы хотите сходить");
        while (running){
            String input = scanner.nextLine();
            if (input.matches("[wasdWASD]*")) {
                makeMove(input.toLowerCase());
                createFood();
                printMap();
            }
            else{
                System.out.println("Try again");
                break;
            }
        }
        printMap();
    }

    public static void makeMove(String WASD){
        //очистка последнего хвоста
        map[positions.getLast()[0]][positions.getLast()[1]] = FIELD;
        //ТУША
        int[] newTail = new int[]{positions.getLast()[0], positions.getLast()[1]};
        for (int i = positions.size()-1; i > 0; i--) {
            positions.set(i, new int[]{positions.get(i-1)[0], positions.get(i-1)[1]});
        }
        //ГОЛОВА
        switch (WASD){
            case "w" -> positions.getFirst()[0] -= 1;
            case "s" -> positions.getFirst()[0] += 1;
            case "a" -> positions.getFirst()[1] -= 1;
            default -> positions.getFirst()[1] += 1;
        }
        if (map[positions.getFirst()[0]][positions.getFirst()[1]].equalsIgnoreCase(WALL) || (map[positions.getFirst()[0]][positions.getFirst()[1]].equalsIgnoreCase(BODY))){
            System.out.println("You lost");
            running = false;
            return;
        }
        if (map[positions.getFirst()[0]][positions.getFirst()[1]].equalsIgnoreCase(FOOD)){
            positions.add(newTail);
        }
        for (int i = 1; i < positions.size(); i++) {
            map[positions.get(i)[0]][positions.get(i)[1]] = BODY;
        }
        map[positions.getFirst()[0]][positions.getFirst()[1]] = HEAD;
    }

    public static void createMap(){
        System.out.println("Доброе пожаловать в игру Змейка, снизу расположена изначальная карта");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i == 0) {
                    map[i][j] = WALL;
                }else if (i == 19) {
                    map[i][j] = WALL;
                } else if (i != 0 && i != 19 && (j == 0 || j ==19)) {
                    map[i][j] = WALL;
                }else{
                    map[i][j] = FIELD;
                }
            }
        }
    }

    public static void createFood(){
        Random random = new Random();
        int x = random.nextInt(map.length);
        int y = random.nextInt(map.length);
        if (!(map[y][x].equals(WALL))){
            map[random.nextInt(map.length)][random.nextInt(map.length)] = FOOD;
        }
    }

    public static void createFirstSnake(){
        map[6][6] = HEAD; map[6][7] = BODY; map[6][8] = BODY;
        positions.add(new int[]{6, 6});
        positions.add(new int[]{6, 7});
        positions.add(new int[]{6,8});
    }

    public static void printMap(){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

