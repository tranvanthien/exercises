package bai42;

public class  Main {
    public static void main(String[] args) {
        Student student = new Student("Thiện", "123", "Computer Science", 2, 2000.0);
        Staff staff = new Staff("Như", "456", "VKU", 35000.0);

        System.out.println(student);
        System.out.println(staff);
    }
}

