package bai32;

public class Test {
	public static void main(String[] args) {
		MyPolynomial p1 = new MyPolynomial(1, 2, 3); // 3x² + 2x + 1
        MyPolynomial p2 = new MyPolynomial(2, 3);   // 3x + 2

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        System.out.println("p1 degree: " + p1.getDegree());
        System.out.println("p2 evaluated at x=2: " + p2.evaluate(2));

        MyPolynomial sum = p1.add(p2);
        System.out.println("Sum (p1 + p2): " + sum);

        MyPolynomial product = p1.multiply(p2);
        System.out.println("Product (p1 * p2): " + product);
	}

}
