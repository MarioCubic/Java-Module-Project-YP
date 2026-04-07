import java.awt.*;
import java.util.Scanner;

public class Main {
    public static int leaderDistance = 0;
    public static String leaderName;

    public static final int MAX_SPEED = 250;
    public static final int MIN_SPEED = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        userInput();
        System.out.println("Самая быстрая машина: " + leaderName);
    }


    private static void userInput(){
        for (int i = 1; i < 4; i++) {
            String name = "";
            while (name.isEmpty()) {
                System.out.println("Введите название машины №" + i + ":");
                name = scanner.nextLine();
            }
            boolean checkEntry = true;
            int speed = 0;
            while (checkEntry){

                System.out.println("Введите скорость машины №" + i + ":");


                try {
                    speed = Integer.parseInt(scanner.nextLine());
                    if(speed < MIN_SPEED || speed > MAX_SPEED){
                        System.out.println("Неправильная скорость");

                    }
                    else{
                        checkEntry = false;

                    }
                }
                catch (NumberFormatException e){

                    System.out.println("Неверное значение");

                }

            }
            Race.race (new Car(name, speed));

        }
    }
}

class Race {
    private static final int RACE_TIME = 24;

    public static void race(Car car) {
        int distance = car.speed * RACE_TIME;
        if(distance > Main.leaderDistance){
            Main.leaderDistance = distance;
            Main.leaderName = car.name;
        }


    }

}


class Car {
    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}