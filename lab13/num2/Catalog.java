package lab13.num2;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<String> list = new ArrayList<>();

    public Catalog(List<String> list) {
        this.list = list;
    }

    public String search(String element){
        boolean flag = false;
        String[] currentString = new String[]{};
        for (int i = 0; i < list.size(); i++) {
            currentString = list.get(i).split(", ");
            if (currentString[0].equals(element)) {
                flag = true;
            }
        }
        if (flag){
            String result = "";
            for (int i = 0; i < list.size(); i++) {
                currentString = list.get(i).split(", ");
                result += currentString[1] + " ";
            }
            return result;
        } else return "No such shop";
    }

    public void addElement(String element){
        this.list.add(element);
    }

    @Override
    public String toString() {
        String result = "";
        String[] currentString = new String[]{};
        for (int i = 0; i < list.size(); i++) {
            currentString = list.get(i).split(", ");
            result += (currentString[1] + ": " + currentString[2] + "$ in " + currentString[0]) + "\n";
        }
        return result;
    }
}
