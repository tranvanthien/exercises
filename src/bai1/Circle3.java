package bai1;

public class Circle3 {
    private float leght = 1.0f;
    private float width = 1.0f;

    public Circle3() {
    }

    public Circle3(float width, float leght) {
        this.width = width;
        this.leght = leght;
    }

    public float getLeght() {
        return leght;
    }

    public void setLeght(float leght) {
        this.leght = leght;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Circle3{" +
                "leght=" + leght +
                ", width=" + width +
                '}';
    }

    public  double getArea(){
        return leght*width;
    }
    public  double getCircumference(){
        return (leght+width)*2;
    }

    public static void main(String[] args) {
        Circle3 r1=new Circle3(2f,3f);
        System.out.println(r1);
        Circle3 r2=new Circle3();
        System.out.println(r2);
        r1.setLeght(2.1f);
        r1.setWidth(1.2f);
        System.out.println(r1);
        System.out.println("leght: "+r1.getLeght());
        System.out.println("width: "+r1.getWidth());
        System.out.println("Area: "+r1.getArea());
        System.out.println("Circumference: "+r1.getCircumference());
    }
}