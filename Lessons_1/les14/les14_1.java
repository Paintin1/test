package Lessons_1.les14;
//Наследование
public class les14_1 {
    public static void main(String[] args) {
        Car bmw = new Car(250.5f, 2500, "White", new byte[] {0, 0, 0});

        Truck truck = new Truck(5600, new byte[] {110, 0, 110}, false);

        truck.setLoaded(true);
        truck.getLoaded();
    }
}
