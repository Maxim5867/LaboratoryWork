package autopark.persons;

import java.util.Objects;
import java.util.Set;

public class CarDriver extends Driver {
    private int carDriverExperience;


    public CarDriver(String firstName, String lastName, String license, Set<String> driverCategories, int carDriverExperience) {
        super(firstName, lastName, license, driverCategories);
        this.setCarDriverExperience(carDriverExperience);
    }

    public int getCarDriverExperience() {
        return carDriverExperience;
    }

    public void setCarDriverExperience(int carDriverExperience) {
        this.carDriverExperience = carDriverExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarDriver carDriver = (CarDriver) o;
        return carDriverExperience == carDriver.carDriverExperience;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carDriverExperience);
    }

    @Override
    public String toString() {
        return "CarDriver{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", licenseNumber='" + getLicenseNumber() + '\'' +
                ", driverCategories=" + getDriverCategories() +
                '}';
    }
}
