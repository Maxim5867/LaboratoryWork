package main;

import autopark.AutoparkManagementSystem;
import autopark.persons.CarDriver;
import autopark.persons.Driver;
import autopark.persons.TruckDriver;
import autopark.vehicles.Bus;
import autopark.vehicles.Car;
import autopark.vehicles.Truck;
import autopark.vehicles.Vehicle;

import java.util.*;

public class Main {
    static boolean flag = true;
    static Scanner scanner = new Scanner(System.in);
    static AutoparkManagementSystem system = new AutoparkManagementSystem();
    public static void main(String[] args) {
        while (flag) {
            try {
                try {
                    printMenu();
                    String input = scanner.nextLine();
                    switch (input) {
                        case "1":
                            addVehicle();
                            break;
                        case "2":
                            addDriver();
                            break;
                        case "3":
                            listVehicle();
                            break;
                        case "4":
                            listDriver();
                            break;
                        case "5":
                            searchVehicle();
                            break;
                        case "6":
                            searchDriver();
                            break;
                        case "7":
                            saveToFile();
                            break;
                        case "8":
                            assignVehicle();
                            break;
                        case "9":
                            releaseVehicle();
                            break;
                        case "10":
                            removeVehicle();
                            break;
                        case "11":
                            removeDriver();
                            break;
                        case "12":
                            getAvailableVehicle();
                            break;
                        case "13":
                            getAssignedVehicle();
                            break;
                        case "14":
                            sortVehicles();
                            break;
                        case "15":
                            sortDrivers();
                            break;
                        case "16":
                            flag = false;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input" +
                            "\n Try again");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid input");
            }
        }
    }
    public static void printMenu(){
        System.out.println("1: Добавить ТС" +
                "\n2: Добавить водителя" +
                "\n3: Список ТС" +
                "\n4: Список водителей" +
                "\n5: Поиск ТС" +
                "\n6: Поиск водителя" +
                "\n7: Сохранить в файл" +
                "\n8: Назначить водителя" +
                "\n9: Открепить водителя" +
                "\n10: Удалить ТС" +
                "\n11: Удалить водителя" +
                "\n12: Список свободных ТС" +
                "\n13: Список занятых ТС" +
                "\n14: Сортировать ТС" +
                "\n15: Сортировать водителей" +
                "\n16: Выйти");
    }

    public static void addVehicle(){
        System.out.println("What Type?");
        System.out.println("1 - Car, 2 - Bus, 3 - Truck");
        String type = scanner.nextLine();
        System.out.println("What Brand?");
        String brand = scanner.nextLine();
        System.out.println("What model?");
        String model = scanner.nextLine();
        System.out.println("What Registration Number?");
        String reg = scanner.nextLine();
        System.out.println("What Year?");
        String year = scanner.nextLine();

        switch (type){
            case "1":
                System.out.println("What passenger Capacity?");
                String cap = scanner.nextLine();
                system.addVehicles(new Car(brand, model, reg, Integer.parseInt(year), Integer.parseInt(cap)));
                break;
            case "2":
                System.out.println("What seat Count?");
                String seat = scanner.nextLine();
                system.addVehicles(new Bus(brand, model, reg, Integer.parseInt(year), Integer.parseInt(seat)));
                break;
            case "3":
                System.out.println("What cargo Capacity?");
                String cargo = scanner.nextLine();
                system.addVehicles(new Truck(brand, model, reg, Integer.parseInt(year), Double.parseDouble(cargo)));
                break;
            default: throw new IllegalArgumentException();
        }
    }
    public static void addDriver() {
        System.out.println("What are you driving?");
        System.out.println("1 - Car, 2 - Truck");
        String type = scanner.nextLine();
        System.out.println("What First Name?");
        String firstName = scanner.nextLine();
        System.out.println("What Last Name?");
        String lastName = scanner.nextLine();
        System.out.println("What License Number?");
        String license = scanner.nextLine();
        System.out.println("What categories?");
        String categories = scanner.nextLine();
        Set<String> driverCategories = new HashSet<>();
        driverCategories.add(categories);

        switch (type) {
            case "1":
                System.out.println("What experience?");
                String exp = scanner.nextLine();
                system.addDrivers(new CarDriver(firstName, lastName, license, driverCategories, Integer.parseInt(exp)));
                break;
            case "2":
                System.out.println("What cargo Capacity?");
                String cargo = scanner.nextLine();
                system.addDrivers(new TruckDriver(firstName, lastName, license, driverCategories, Double.parseDouble(cargo)));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void listVehicle(){
        List<Vehicle> list = new ArrayList<>();
        for (Vehicle v: system.getVehicles()){
            System.out.println(v);
        }
    }

    public static void listDriver(){
        List<Driver> list = new ArrayList<>();
        for (Driver d: system.getDrivers()){
            System.out.println(d);
        }
    }

    public static void searchVehicle(){
        System.out.println("Enter Registration Number or Brand or Model or Year");
        String input = scanner.nextLine();
        System.out.println(system.searchVehicles(input));
    }

    public static void searchDriver(){
        System.out.println("Enter First Name or Last Name or License Number");
        String input = scanner.nextLine();
        System.out.println(system.searchDrivers(input));
    }

    public static void saveToFile(){
        system.saveToFile();
    }

    public static void assignVehicle(){
        Driver driver = null;
        Vehicle vehicle = null;
        System.out.println("Enter License Number for Driver");
        String inputForDriver = scanner.nextLine();
        System.out.println("Enter Registration Number for Vehicle");
        String inputForVehicle = scanner.nextLine();
        for (Driver d: system.getDrivers()){
            if (d.getLicenseNumber().toLowerCase().contains(inputForDriver.toLowerCase())){
                driver = d;
            }
        }
        for (Vehicle v: system.getVehicles()){
            if (v.getRegistrationNumber().toLowerCase().contains(inputForVehicle.toLowerCase())){
                vehicle = v;
            }
        }
        system.assignVehicles(driver,vehicle);
    }

    public static void releaseVehicle(){
        Driver driver = null;
        Vehicle vehicle = null;
        System.out.println("Enter License Number for Driver");
        String inputForDriver = scanner.nextLine();
        System.out.println("Enter Registration Number for Vehicle");
        String inputForVehicle = scanner.nextLine();
        for (Driver d: system.getDrivers()){
            if (d.getLicenseNumber().toLowerCase().contains(inputForDriver.toLowerCase())){
                driver = d;
            }
        }
        for (Vehicle v: system.getVehicles()){
            if (v.getRegistrationNumber().toLowerCase().contains(inputForVehicle.toLowerCase())){
                vehicle = v;
            }
        }
        system.releaseVehicles(driver,vehicle);
    }
    public static void removeVehicle(){
        Vehicle vehicle = null;
        System.out.println("Enter Registration Number for Vehicle");
        String inputForVehicle = scanner.nextLine();
        for (Vehicle v: system.getVehicles()){
            if (v.getRegistrationNumber().toLowerCase().contains(inputForVehicle.toLowerCase())){
                vehicle = v;
            }
        }
        system.removeVehicles(vehicle);
    }
    public static void removeDriver(){
        Driver driver = null;
        System.out.println("Enter License Number for Driver");
        String inputForDriver = scanner.nextLine();
        for (Driver d: system.getDrivers()){
            if (d.getLicenseNumber().toLowerCase().contains(inputForDriver.toLowerCase())){
                driver = d;
            }
        }
        system.removeDrivers(driver);
    }
    public static void getAvailableVehicle(){
        List<Vehicle> availableVehicle = system.getAvailableVehicle();
        for (Vehicle v: availableVehicle){
            System.out.println(v);
        }
    }
    public static void getAssignedVehicle(){
        System.out.println(system.getAssignedVehicles());
    }

    public static void sortVehicles(){
        System.out.println("По какому критерию вы хотите сортировку?");
        System.out.println("1 - Brand, 2 - Model, 3 - Year");
        String input = scanner.nextLine();
        switch (input){
            case "1":
                system.sortByBrand();
                listVehicle();
                break;
            case "2":
                system.sortByModel();
                listVehicle();
                break;
            case "3":
                system.sortByYear();
                listVehicle();
                break;
            default: throw new IllegalArgumentException();
        }
    }
    public static void sortDrivers(){
        System.out.println("По какому критерию вы хотите сортировку?");
        System.out.println("1 - Имя, 2 - Фамилия");
        String input = scanner.nextLine();
        switch (input){
            case "1":
                system.sortByFirstName();
                listDriver();
                break;
            case "2":
                system.sortByLastName();
                listDriver();
                break;
            default: throw new IllegalArgumentException();
        }
    }
}
