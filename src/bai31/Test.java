package bai31;

public class Test {
	public static void main(String[] args) {
		MyComplex complex1=new MyComplex(3,0);
		MyComplex complex2=new MyComplex(4,5.5);
		 System.out.println("Số phức 1: " + complex1);
	        System.out.println("Số phức 2: " + complex2);

	        System.out.println("Magnitude của c1: " + complex1.magnitude());
	        System.out.println("complex1 có phải số thực? " + complex1.isReal());
	        System.out.println("complex1 có phải số ảo? " + complex1.isImaginary());

	        MyComplex sum = complex1.addNew(complex2);
	        System.out.println("Tổng complex1 + complex2 = " + sum);

	        complex1.addInto(complex2);
	        System.out.println("Sau khi cộng vào, c1 = " + complex1);
	}

}
