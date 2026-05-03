package lab10.num1;

public class Pensioner extends BasePerson {

    public Pensioner(String ivanKuzmich) {
        super(ivanKuzmich);
    }

    public String getEmployment(){
        return "is resting";
    }
    public String toString(){
        return super.getName() + " " + getEmployment();
    }

}
