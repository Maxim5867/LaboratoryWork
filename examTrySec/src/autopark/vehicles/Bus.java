package autopark.vehicles;

import java.util.Objects;

public class Bus extends Vehicle {
    private int seatCount;

    public Bus(String brand, String model, String reg, int year, int seatCount) {
        super(brand,model, reg, year, VehiclesStatus.FREE, VehiclesType.BUS);
        this.setSeatCount(seatCount);
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance/100 * seatCount * 5;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return seatCount == bus.seatCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(seatCount);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", registrationNumber='" + getRegistrationNumber() + '\'' +
                ", year=" + getYear() +
                ", type=" + getType() +
                ", status=" + getStatus() +
                '}';
    }
}
