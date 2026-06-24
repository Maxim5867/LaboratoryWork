package autopark.vehicles;

import java.util.Objects;

public class Car extends Vehicle {
    private int passengerCapacity;

    public Car(String brand, String model, String reg, int year, int passengerCapacity) {
        super(brand,model, reg, year, VehiclesStatus.FREE, VehiclesType.CAR);
        this.setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance/100 * passengerCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return passengerCapacity == car.passengerCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(passengerCapacity);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", registrationNumber='" + getRegistrationNumber() + '\'' +
                ", year=" + getYear() +
                ", type=" + getType() +
                ", status=" + getStatus() +
                '}';
    }
}
