
public class Exponential {
	public static double EulerExponential(double x, int numTerms) {
		double result = 1.0; 
        double term = 1.0;   

        for (int i = 1; i <= numTerms; i++) {
            term *= x / i;   
            result += term;  
        }

        return result;
	}
}
