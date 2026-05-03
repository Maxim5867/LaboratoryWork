package lab10.num1;

public class Main {
    public static void main(String[] args) {

        Person[] mock = new Person[3];
        mock[0] = new Worker("Petr");
        mock[1] = new Student("Gleb");
        mock[2] = new Pensioner("Ivan Kuzmich");
        mock[2] = new Pensioner("Ivan Kuzmich");

        System.out.println(mock[0]);
        System.out.println(mock[1]);
        System.out.println(mock[2]);


    }
}
