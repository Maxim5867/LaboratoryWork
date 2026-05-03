package lab13.num1;

import java.util.Arrays;

public class Treemap {
    private String[] map = new String[]{};
    private int id;
    private String name;

    public Treemap(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public void push(){
        boolean flag = true;
        int len = map.length;
        for (int i = 0; i < len; i++) {
            String[] testArray = new String[]{};
            testArray = map[i].split(" ");
            if (Integer.parseInt(testArray[0]) == id){
                flag = false;
            }
        }
        if (flag) {
            String[] array1 = new String[len + 1];
            for (int i = 0; i < len; i++) {
                array1[i] = map[i];
            }
            array1[len] = (this.id + " = " + this.name);
            map = array1;
            Arrays.sort(map);
        } else System.out.println("Duplicate");
    }

    public void pop(){
        int deleteElement = 0;
        boolean flag = false;
        int len = map.length;
        for (int i = 0; i < len; i++) {
            String[] testArray = new String[]{};
            testArray = map[i].split(" ");
            if (Integer.parseInt(testArray[0]) == id){
                flag = true;
                deleteElement = i;
            }
        }
        if (flag) {
            String[] arrayResult;
            String[] array1 = new String[deleteElement];
            for (int i = 0; i < deleteElement; i++) {//первая часть массива перед удаленным элементом
                array1[i] = map[i];
            }
            if (map.length-1 > array1.length){//если после удаленного момента есть еще имена
                String[] array2 = new String[map.length];
                for (int i = deleteElement+1; i < map.length; i++) { //заполнение второй части массива после удаленного элемента
                    array2[i] = map[i];
                }

                int k = 0;
                int normalElement = 0;
                for (int i = 0; i < array2.length; i++) {
                    if (array2[i] != null){
                        normalElement = i;
                        k++;
                    }
                }
                String[] array3 = new String[k];
                for (int j = 0; j < k; j++) {
                    array3[j] = array2[normalElement];
                    normalElement++;
                }
                arrayResult = new String[array1.length + array3.length];
                for (int j = 0; j < array1.length; j++) {
                    arrayResult[j] = array1[j];
                }
                int l = 0;
                for (int j = array3.length; j < array3.length+1; j++) {
                    arrayResult[j] = array3[l];
                    l++;
                }

                map = arrayResult;

            } else  map = array1;
        } else System.out.println("No such id");
    }

    public void search(){
        boolean flagForId = false;
        boolean flagForName = false;
        int len = map.length;
        for (int i = 0; i < len; i++) {
            String[] testArray = new String[]{};
            testArray = map[i].split(" ");
            if (id != Integer.MAX_VALUE) {
                if (Integer.parseInt(testArray[0]) == id) {
                    System.out.println(testArray[2]);
                    flagForId = true;
                    break;
                }
            } else {
                if (testArray[2].equals(name)){
                    System.out.println("Yes");
                    flagForName = true;
                    break;
                }
            }
        }
        if (id != Integer.MAX_VALUE){
            if (!flagForId){
                System.out.println("No such number");
            }
        } else {
            if (!flagForName){
                System.out.println("No");
            }
        }
        id = Integer.MAX_VALUE;
    }

    public void setId(int id) {
        if (id == 0){
            throw new IllegalArgumentException("Invalid ID");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank() || name.matches("[0-9]+")){
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return Arrays.toString(map);
    }
}
