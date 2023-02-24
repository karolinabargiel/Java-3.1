package sii.sup;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var truck1 = new Truck(250);
        var truck2 = new Truck(300);
        var boat1 = new Boat(400);
        var boat2 = new Boat(450);
        var human1 = new Human();
        var human2 = new Human();
        var truck3 = new Truck(350) {
            @Override
            public void move() {
                System.out.println("Im super truck I can drive with 350km/h");
            }
        };
        List<Mobile> list = List.of(truck1, truck2, truck3, boat1, boat2, human1, human2);
        var randomObject = processList(list);
        randomObject.move();
        print(() -> System.out.println("I cannot run at all"));
        introduce(name -> System.out.println("Hello " + name));

    }

    public static void print(Mobile mobile) {
        mobile.move();
    }

    public static void introduce(Talkable talkable) {
        talkable.sayHello("Mateusz");
    }

    public static <T extends Mobile> T processList(List<T> list) {
        Random random = new Random();
        for (T mobile : list) {
            if (mobile instanceof Vehicle vehicle) {
                System.out.println("To jest pojazd");
                System.out.println("Max speed: " + vehicle.getMaxSpeed());
            } else {
                System.out.println("To nie jest pojazd");
            }
        }
        return list.get(random.nextInt(list.size()));
    }
}