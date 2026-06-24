package autopark.persons;

import autopark.interfaces.Searchable;
import autopark.vehicles.Vehicle;

import java.util.Objects;
import java.util.Set;

public abstract class Driver implements Searchable<Driver> {
    private String firstName;
    private String lastName;
    private String licenseNumber;
    private Vehicle assignedVehicle;
    private Set<String> driverCategories;

    public Driver(String firstName, String lastName, String licenseNumber, Vehicle assignedVehicle, Set<String> driverCategories) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setLicenseNumber(licenseNumber);
        this.setAssignedVehicle(assignedVehicle);
        this.setDriverCategories(driverCategories);
    }

    public Driver() {

    }

    public Driver(String firstName, String lastName, String licenseNumber, Set<String> driverCategories) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setLicenseNumber(licenseNumber);
        this.setDriverCategories(driverCategories);
    }

    public void assignVehicle(Vehicle vehicle){
        if (vehicle == null){
            throw new IllegalArgumentException("Invalid vehicle");
        }
        this.assignedVehicle = vehicle;

    }

    public void releaseVehicle(Vehicle vehicle){
        if (vehicle == null){
            throw new IllegalArgumentException("Invalid vehicle");
        }this.assignedVehicle = null;

    }

    public String getDriverDetails(){
        return "Driver{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", assignedVehicle=" + assignedVehicle +
                ", driverCategories=" + driverCategories +
                '}';
    }

    public boolean matches(String query){
        return getFirstName().toLowerCase().contains(query.toLowerCase()) || getLastName().toLowerCase().contains(query.toLowerCase()) || getLicenseNumber().toLowerCase().contains(query.toLowerCase());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Vehicle getAssignedVehicle() {
        return assignedVehicle;
    }

    public void setAssignedVehicle(Vehicle assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }

    public Set<String> getDriverCategories() {
        return driverCategories;
    }

    public void setDriverCategories(Set<String> driverCategories) {
        this.driverCategories = driverCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(firstName, driver.firstName) && Objects.equals(lastName, driver.lastName) && Objects.equals(licenseNumber, driver.licenseNumber) && Objects.equals(assignedVehicle, driver.assignedVehicle) && Objects.equals(driverCategories, driver.driverCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, licenseNumber, assignedVehicle, driverCategories);
    }

    @Override
    public String toString() {
        return getDriverDetails();
    }
}
