package lab10.num1;

public class Student extends BasePerson{

    public Student(String gleb) {
        super(gleb);
    }

    public String getEmployment(){
        return "study";
    }

    public String toString(){
        return super.getName() + " " + getEmployment();
    }
}
