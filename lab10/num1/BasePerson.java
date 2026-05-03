package lab10.num1;

public abstract class BasePerson implements Person {
    private String name;

    public BasePerson(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else throw new IllegalArgumentException("Invalid");
    }

    public String getName() {
        return name;
    }

    public abstract String getEmployment();
}
