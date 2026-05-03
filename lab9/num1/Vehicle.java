package lab9.num1;

public class Vehicle {
    protected int passengers;

    protected Vehicle(int passengers) {
        this.setPassengers(passengers);
    }

    protected void setPassengers(int passengers) {
        if (passengers < 0) {
            throw new Error("Invalid negative number ! Argument: passengers ");
        }
        else if (passengers == 0){
            throw new Error("Need passengers to drive!");
        }
        else this.passengers = passengers;
    }
}
