package autopark.vehicles;

import java.util.Objects;

public class Truck extends Vehicle {
    private double cargoCapacity;

    public Truck(String brand, String model, String reg, int year, double cargoCapacity) {
        super(brand,model, reg, year, VehiclesStatus.FREE, VehiclesType.TRUCK);
        this.setCargoCapacity(cargoCapacity);
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance/100 * cargoCapacity * 10;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return Double.compare(cargoCapacity, truck.cargoCapacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cargoCapacity);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", registrationNumber='" + getRegistrationNumber() + '\'' +
                ", year=" + getYear() +
                ", type=" + getType() +
                ", status=" + getStatus() +
                '}';
    }
}
