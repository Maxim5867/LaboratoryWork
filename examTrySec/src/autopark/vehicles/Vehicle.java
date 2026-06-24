package autopark.vehicles;

import autopark.interfaces.Searchable;
import autopark.persons.Driver;

import java.util.Objects;

public abstract class Vehicle implements Searchable<Vehicle> {
    private String brand;
    private String model;
    private String registrationNumber;
    private Driver assignedDriver;
    private int year;
    private VehiclesType type;
    private VehiclesStatus status;

    public Vehicle(String brand, String model, String registrationNumber, Driver assignedDriver, int year, VehiclesType type, VehiclesStatus status) {
        this.setBrand(brand);
        this.setModel(model);
        this.setRegistrationNumber(registrationNumber);
        this.setAssignedDriver(assignedDriver);
        this.setYear(year);
        this.setType(type);
        this.setStatus(status);
    }

    public Vehicle() {

    }

    public Vehicle(String brand, String model, String registrationNumber, int year, VehiclesStatus status, VehiclesType type) {
        this.setBrand(brand);
        this.setModel(model);
        this.setRegistrationNumber(registrationNumber);
        this.setYear(year);
        this.setType(type);
        this.setStatus(status);
    }

    public void assignToDriver(Driver driver){
        if (driver == null){
            throw new IllegalArgumentException("Invalid driver");
        }
        this.assignedDriver = driver;
        this.status = VehiclesStatus.BUSY;

    }

    public void releaseFromDriver(){
        this.assignedDriver = null;
        this.status = VehiclesStatus.FREE;
    }

    public String getVehicleDetails(){
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", assignedDriver=" + assignedDriver +
                ", year=" + year +
                ", type=" + type +
                ", status=" + status +
                '}';
    }

    public abstract double calculateFuelConsumption(double distance);

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public VehiclesType getType() {
        return type;
    }

    public void setType(VehiclesType type) {
        this.type = type;
    }

    public VehiclesStatus getStatus() {
        return status;
    }

    public void setStatus(VehiclesStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && Objects.equals(registrationNumber, vehicle.registrationNumber) && Objects.equals(assignedDriver, vehicle.assignedDriver) && type == vehicle.type && status == vehicle.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, registrationNumber, assignedDriver, year, type, status);
    }

    @Override
    public String toString() {
        return getVehicleDetails();
    }

    public boolean matches(String query){
        return getRegistrationNumber().toLowerCase().contains(query.toLowerCase()) || getBrand().toLowerCase().contains(query.toLowerCase()) || getModel().toLowerCase().contains(query.toLowerCase()) || String.valueOf(getYear()).contains(query);
    }
}
