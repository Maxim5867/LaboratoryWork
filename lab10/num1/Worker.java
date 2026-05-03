package lab10.num1;

public class Worker extends BasePerson {

    public Worker(String petr) {
        super(petr);
    }

    public String getEmployment(){
        return "works";
    }
    public String toString(){
        return super.getName() + " " + getEmployment();
    }
}
