package bai52;

public class Main {
    public static void main(String[] args) {

        Cylinder cyl = new Cylinder(2.5, "blue", 5.0);


        System.out.println("Cylinder Base Radius: " + cyl.getBaseRadius());
        System.out.println("Cylinder Base Color: " + cyl.getBaseColor());
        System.out.println("Cylinder Height: " + cyl.getHeight());
        System.out.println("Cylinder Volume: " + cyl.getVolume());
    }
}
