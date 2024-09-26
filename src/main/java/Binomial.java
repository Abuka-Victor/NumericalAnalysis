public class BinomialExpansion {

    // Method to compute the factorial of a number
    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Method to compute the binomial coefficient
    private static long binomialCoefficient(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    // Method to compute (a + b)^n using binomial expansion
    public static double binomialExpansion(double a, double b, int n) {
        double result = 0;
        for (int k = 0; k <= n; k++) {
            double coefficient = binomialCoefficient(n, k);
            result += coefficient * Math.pow(a, n - k) * Math.pow(b, k);
        }
        return result;
    }

    public static void main(String[] args) {
        double a = 1.0;
        double b = 2.0;
        int n = 3;
        System.out.println("Binomial Expansion of (a + b)^n: " + binomialExpansion(a, b, n));
    }
}


/* Application: Modeling Voltage Divider Circuits
Problem: Consider a voltage divider circuit with resistors R1 and R2 connected in series, where the input voltage is Vin.
The output voltage Vout across R2 can be expressed using the voltage divider formula.
        Vout = Vin * (R2/(R1 + R2))
For a more complex scenario, if R1 and R2 are expressed as polynomials in terms of some variable x, such as R1 = (1 + x)^3
and R2 = (2 - x)^2 , you might need to compute the polynomial expansion for these resistances.
*/

public class VoltageDivider {

    public static void main(String[] args) {
        double x = 0.5; // Example value for the variable x
        double V_in = 12.0; // Input voltage in volts
        
        // Define polynomials for resistors
        double R1 = binomialExpansion(1, x, 3); // (1 + x)^3
        double R2 = binomialExpansion(2, -x, 2); // (2 - x)^2
        
        // Calculate output voltage using the voltage divider formula
        double V_out = V_in * (R2 / (R1 + R2));
        
        System.out.printf("Output Voltage V_out: %.2f V\n", V_out);
    }

    // Method to compute (a + b)^n using binomial expansion
    public static double binomialExpansion(double a, double b, int n) {
        double result = 0;
        for (int k = 0; k <= n; k++) {
            double coefficient = binomialCoefficient(n, k);
            result += coefficient * Math.pow(a, n - k) * Math.pow(b, k);
        }
        return result;
    }

    // Method to compute the binomial coefficient
    private static long binomialCoefficient(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    // Method to compute the factorial of a number
    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
