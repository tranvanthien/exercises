package bai34;

public class Test {
	public static void main(String[] args) {
		MyTime time = new MyTime(23, 59, 59);
        System.out.println("Current Time: " + time);
        time.nextSecond();
        System.out.println("After next second: " + time);
        time.previousSecond();
        System.out.println("After previous second: " + time);
	}

}
