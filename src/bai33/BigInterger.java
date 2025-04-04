package bai33;
import java.math.BigInteger;
public class BigInterger {
	    public static void main(String[] args) {
	    	String num1 = "11111111111111111111111111111111111111111111111111111111111111";
	        String num2 = "22222222222222222222222222222222222222222222222222";
	        
	        // Create BigInteger instances
	        BigInteger bigInt1 = new BigInteger(num1);
	        BigInteger bigInt2 = new BigInteger(num2);
	        
	        // Perform addition
	        BigInteger sum = bigInt1.add(bigInt2);
	        System.out.println("Sum: " + sum);
	        
	        // Perform multiplication
	        BigInteger product = bigInt1.multiply(bigInt2);
	        System.out.println("Product: " + product);


}
}