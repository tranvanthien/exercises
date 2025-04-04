package bai210;


public class MVC {
	public static void main(String[] args) {
		
	System.out.println("+----------------+\r\n"
			+ "|   MyPoint      |\r\n"
			+ "+----------------+\r\n"
			+ "| - x: int      |\r\n"
			+ "| - y: int      |\r\n"
			+ "+----------------+\r\n"
			+ "| + MyPoint(x,y) |\r\n"
			+ "| + getX(): int  |\r\n"
			+ "| + getY(): int  |\r\n"
			+ "| + setX(int)    |\r\n"
			+ "| + setY(int)    |\r\n"
			+ "| + toString(): String |\r\n"
			+ "+----------------+\r\n"
			+ "\r\n"
			+ "+----------------+\r\n"
			+ "|  MyRectangle   |\r\n"
			+ "+----------------+\r\n"
			+ "| - topLeft: MyPoint  |\r\n"
			+ "| - bottomRight: MyPoint |\r\n"
			+ "+----------------+\r\n"
			+ "| + MyRectangle(MyPoint, MyPoint) |\r\n"
			+ "| + getTopLeft(): MyPoint |\r\n"
			+ "| + getBottomRight(): MyPoint |\r\n"
			+ "| + setTopLeft(MyPoint) |\r\n"
			+ "| + setBottomRight(MyPoint) |\r\n"
			+ "| + getWidth(): int |\r\n"
			+ "| + getHeight(): int |\r\n"
			+ "| + getArea(): int |\r\n"
			+ "| + getPerimeter(): int |\r\n"
			+ "| + toString(): String |\r\n"
			+ "+----------------+\r\n"
			+ "");
	 MyPoint p1 = new MyPoint(2, 10);
     MyPoint p2 = new MyPoint(8, 4);

     MyRectangle rect = new MyRectangle(p1, p2);

     System.out.println(rect); 
     System.out.println("Width: " + rect.getWidth());
     System.out.println("Height: " + rect.getHeight());
     System.out.println("Area: " + rect.getArea());
     System.out.println("Perimeter: " + rect.getPerimeter());
	
}
}