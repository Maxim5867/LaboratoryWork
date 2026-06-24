package autopark;

import autopark.persons.Driver;
import autopark.vehicles.Vehicle;
import autopark.vehicles.VehiclesStatus;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AutoparkManagementSystem {
    private String path = "resources\\data.txt";
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();

    public AutoparkManagementSystem(List<Vehicle> vehicles, List<Driver> drivers) {
        this.setVehicles(vehicles);
        this.setDrivers(drivers);
    }

    public AutoparkManagementSystem() {

    }

    public void addVehicles(Vehicle vehicle){
        if (vehicle == null){
            throw new IllegalArgumentException("Invalid vehicle");
        }
        vehicles.add(vehicle);
    }
    public void addDrivers(Driver driver){
        if (driver == null){
            throw new IllegalArgumentException("Invalid driver");
        }
        drivers.add(driver);

    }
    public void removeVehicles(Vehicle vehicle){
        if (vehicle == null){
            throw new IllegalArgumentException("Invalid vehicle");
        } else if (vehicle.getStatus() == VehiclesStatus.BUSY) {
            throw new IllegalArgumentException("Vehicles is Busy");
        }
        vehicles.remove(vehicle);

    }
    public void removeDrivers(Driver driver){
        if (driver == null){
            throw new IllegalArgumentException("Invalid driver");
        }
        drivers.remove(driver);

    }

    public void assignVehicles(Driver driver, Vehicle vehicle){
        if (driver == null || vehicle == null || vehicle.getStatus() == VehiclesStatus.BUSY || vehicle.getStatus() == VehiclesStatus.REPAIR || driver.getAssignedVehicle() != null){
            throw new IllegalArgumentException("Invalid driver or vehicle");
        }
        driver.assignVehicle(vehicle);
        vehicle.assignToDriver(driver);
    }
    public void releaseVehicles(Driver driver, Vehicle vehicle){
        if (driver == null || vehicle == null){
            throw new IllegalArgumentException("Invalid driver or vehicle");
        }
        driver.releaseVehicle(vehicle);
        vehicle.releaseFromDriver();
    }

    public List<Vehicle> searchVehicles(String query){
        List<Vehicle> vehicle = new ArrayList<>();
        for(Vehicle v: vehicles){
            if (v.matches(query)){
                vehicle.add(v);
            }
        }
        return vehicle;
    }
    public List<Driver> searchDrivers(String query){
        List<Driver> driver = new ArrayList<>();
        for(Driver d: drivers){
            if (d.matches(query)){
                driver.add(d);
            }
        }
        return driver;
    }

    public List<Vehicle> getAvailableVehicle(){
        List<Vehicle> availableVehicle = new ArrayList<>();
        for(Vehicle v: vehicles){
            if (v.getStatus() == VehiclesStatus.FREE){
                availableVehicle.add(v);
            }
        }
        return availableVehicle;
    }
    public Map<Driver, Vehicle> getAssignedVehicles(){
        Map<Driver, Vehicle> assignVehicle = new HashMap<>();
        for(Vehicle v: vehicles){
            if (v.getStatus() == VehiclesStatus.BUSY){
                assignVehicle.put(v.getAssignedDriver(), v);
            }
        }
        return assignVehicle;
    }

    public double calculateTotalFuelConsumption(){
        double total = 0;
        for (Vehicle v: vehicles){
            total += v.calculateFuelConsumption(100);
        }
        return total;
    }

    public void saveToFile(){
        try(FileWriter fileWriter = new FileWriter(path, false)){
            for (Vehicle v: vehicles){
                fileWriter.write(v.getVehicleDetails() + System.lineSeparator());
            }
            for (Driver d: drivers){
                fileWriter.write(d.getDriverDetails() + System.lineSeparator());
            }
            fileWriter.flush();
        } catch (IOException e){
            System.out.println(e.getMessage() + " ошибка записи");
        }
    }

    public void sortByBrand(){
        for (int i = 0; i < vehicles.size() - 1 ; i++) {
            for (int j = 0; j < vehicles.size() - 1 - i; j++) {
                if (vehicles.get(j).getBrand().compareTo(vehicles.get(j+1).getBrand()) > 0){
                    Vehicle set = vehicles.get(j);
                    vehicles.set(j, vehicles.get(j+1));
                    vehicles.set(j+1, set);
                }
            }
        }
    }

    public void sortByModel(){
        for (int i = 0; i < vehicles.size() - 1 ; i++) {
            for (int j = 0; j < vehicles.size() - 1 - i; j++) {
                if (vehicles.get(j).getModel().compareTo(vehicles.get(j+1).getModel()) > 0){
                    Vehicle set = vehicles.get(j);
                    vehicles.set(j, vehicles.get(j+1));
                    vehicles.set(j+1, set);
                }
            }
        }
    }

    public void sortByYear(){
        for (int i = 0; i < vehicles.size() - 1 ; i++) {
            for (int j = 0; j < vehicles.size() - 1 - i; j++) {
                if (vehicles.get(j).getYear() > (vehicles.get(j+1).getYear())){
                    Vehicle set = vehicles.get(j);
                    vehicles.set(j, vehicles.get(j+1));
                    vehicles.set(j+1, set);
                }
            }
        }
    }

    public void sortByFirstName(){
        for (int i = 0; i < drivers.size() - 1 ; i++) {
            for (int j = 0; j < drivers.size() - 1 - i; j++) {
                if (drivers.get(j).getFirstName().compareTo(drivers.get(j+1).getFirstName()) > 0){
                    Driver set = drivers.get(j);
                    drivers.set(j, drivers.get(j+1));
                    drivers.set(j+1, set);
                }
            }
        }
    }

    public void sortByLastName(){
        for (int i = 0; i < drivers.size() - 1 ; i++) {
            for (int j = 0; j < drivers.size() - 1 - i; j++) {
                if (drivers.get(j).getLastName().compareTo(drivers.get(j+1).getLastName()) > 0){
                    Driver set = drivers.get(j);
                    drivers.set(j, drivers.get(j+1));
                    drivers.set(j+1, set);
                }
            }
        }
    }


    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AutoparkManagementSystem that = (AutoparkManagementSystem) o;
        return Objects.equals(vehicles, that.vehicles) && Objects.equals(drivers, that.drivers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicles, drivers);
    }

    @Override
    public String toString() {
        return "AutoparkManagementSystem{" +
                "vehicles=" + vehicles +
                ", drivers=" + drivers +
                '}';
    }
}
