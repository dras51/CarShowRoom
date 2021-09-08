import cars.Car;
import cars.ShowRoom;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/*
 *  CREATE CARS
 *  VIEW CARS
 *  VIEW SPECIFIC CAR
 *  REMOVE CARS
 *
 * */
public class Main {

    ShowRoom showRoom = new ShowRoom();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();

        main.showMenu();
    }

    void showMenu(){
        String userInput = "";

        do {
            System.out.println("\nWelcome to show room, please choose activity:");
            System.out.println("1. Add Car");
            System.out.println("2. View All cars");
            System.out.println("3. View Single Car");
            System.out.println("4. Remove car");
            System.out.println("\nEnter Quit to end program...");

            System.out.print("Choose a number:");
            userInput = scanner.nextLine();

            switch (userInput){
                case "quit":
                    System.out.println("Existing application...");
                    break;
                case "1":
                    addCar();
                case "2":
                    viewAllCars();
                    break;
                case "3":
                    viewSingleCar();
                    break;
                case "4":
                    removeCar();
                    break;
                default:
                    break;
            }

            System.out.print("\n Enter any key to continue\n");
            scanner.nextLine();
        } while (!userInput.equalsIgnoreCase("quit") );

        return;
    }

    void addCar(){
        System.out.println("\n Add car ");

        Car car = new Car();
        System.out.print("Enter Name:");
        car.name = scanner.nextLine();

        System.out.print("Enter Manufacturer:");
        car.manufacturer = scanner.nextLine();

        System.out.print("Enter Type:");
        car.type = scanner.nextLine();

        car.id = UUID.randomUUID();

        String message = showRoom.addCar(car);

        System.out.println(message);

    }

    void viewAllCars(){
        ArrayList<Car> allCars = showRoom.getAllCars();

        System.out.println("\nAll available cars\n");
        System.out.println("\tCar Name\t Manufacturer\t Car Type");
        for (Car car: allCars){
            System.out.println(allCars.indexOf(car) + ". \t" + car.name + " \t" + car.manufacturer + " \t" + car.type);
        }
    }

    void  viewSingleCar() {
        Scanner intScanner = new Scanner(System.in);
        System.out.println("View Car\n");
        System.out.println("Please provide the car ID");
        int carId = intScanner.nextInt();

        Car singleCar  = showRoom.getSingleCar(carId);
        System.out.println("Car Number: "  + singleCar.id);
        System.out.println("Car Name: "  + singleCar.name);
        System.out.println("Car Manufacturer: "  + singleCar.manufacturer);
        System.out.println("Car Type: "  + singleCar.type);
    }

    void removeCar() {

        System.out.println("Remove Car\n");
        System.out.println("Please provide the car ID");
        int carId = scanner.nextInt();

        String message = showRoom.removeCar(carId);
        System.out.println(message);
    }
}
