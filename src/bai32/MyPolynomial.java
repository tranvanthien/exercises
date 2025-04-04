package bai32;
import java.util.Arrays;
public class MyPolynomial {
	private double [] coeffs;

	 public MyPolynomial(double... coeffs) {
	        this.coeffs = Arrays.copyOf(coeffs, coeffs.length);
	}
	public int getDegree() {
		return coeffs.length-1;
	}
	@Override
	public String toString() {
		return "MyPolynomial [coeffs=" + Arrays.toString(coeffs) + "]";
	}
	// Tính giá trị đa thức tại x
	public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
	}
     // Cộng hai đa thức 
        public MyPolynomial add(MyPolynomial right) {
            int maxDegree = Math.max(this.getDegree(), right.getDegree());
            double[] newCoeffs = new double[maxDegree + 1];

            for (int i = 0; i <= this.getDegree(); i++) {
                newCoeffs[i] += this.coeffs[i];
            }
            for (int i = 0; i <= right.getDegree(); i++) {
                newCoeffs[i] += right.coeffs[i];
            }

            return new MyPolynomial(newCoeffs);
           
}
    // Nhân hai đa thức 
        public MyPolynomial multiply(MyPolynomial right) {
            int newDegree = this.getDegree() + right.getDegree();
            double[] newCoeffs = new double[newDegree + 1];

            for (int i = 0; i <= this.getDegree(); i++) {
                for (int j = 0; j <= right.getDegree(); j++) {
                    newCoeffs[i + j] += this.coeffs[i] * right.coeffs[j];
                }
            }

            return new MyPolynomial(newCoeffs);
}
        public String toString1() {
            StringBuilder sb = new StringBuilder();
            for (int i = coeffs.length - 1; i >= 0; i--) {
                if (coeffs[i] != 0) {
                    if (sb.length() > 0) {
                        sb.append(" + ");
                    }
                    sb.append(coeffs[i]);
                    if (i > 0) {
                        sb.append("x");
                        if (i > 1) {
                            sb.append("^").append(i);
                        }
                    }
                }
            }
            return sb.toString();
        }
}