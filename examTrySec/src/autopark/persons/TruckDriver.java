package autopark.persons;

import java.util.Objects;
import java.util.Set;

public class TruckDriver extends Driver{
    private double maxManagedCargoCapacity;

    public TruckDriver(String firstName, String lastName, String license, Set<String> driverCategories, double maxManagedCargoCapacity) {
        super(firstName, lastName, license, driverCategories);
        this.setMaxManagedCargoCapacity(maxManagedCargoCapacity);
    }

    public double getMaxManagedCargoCapacity() {
        return maxManagedCargoCapacity;
    }

    public void setMaxManagedCargoCapacity(double maxManagedCargoCapacity) {
        this.maxManagedCargoCapacity = maxManagedCargoCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TruckDriver that = (TruckDriver) o;
        return Double.compare(maxManagedCargoCapacity, that.maxManagedCargoCapacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(maxManagedCargoCapacity);
    }

    @Override
    public String toString() {
        return "TruckDriver{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", licenseNumber='" + getLicenseNumber() + '\'' +
                ", driverCategories=" + getDriverCategories() +
                '}';
    }
}
