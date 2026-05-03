package lab8.num2;

public class Cow {
    private int age;
    private String name;
    private String gender;

    Cow(String cowName, String gender, int age) {
        if (age >= 0) {
            this.age = age;
        }
        else throw new Error("Возраст не может быть отрицательным!");

        if (!(cowName == null) || !(gender == null)) {
            if ((cowName).length() > 2 && !(cowName).isEmpty()) {
                this.name = cowName;
            } else throw new Error("Не может быть пустого имени или имени короче трех сиволов!");

            if (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("male")) {
                this.gender = gender;
            } else throw new Error("Не можеть быть другого пола!");
        } else throw new Error("Не может быть корова без имени или гендера");
    }

    public int getProductivity(){
        if (gender.equalsIgnoreCase("male") || age < 2){
            return 0;
        }
        else if (age > 15){
            return 10;
        }
        else return 20;
    }

    public void addOneYear(){
        age++;
    }

    public String getInfo(){
        return ("Cow " + name + " gives " + getProductivity() + " litres of milk per day ");
    }


}
