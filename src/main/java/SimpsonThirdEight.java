public class Simpsons38Rule {

    // Functional interface for the function to integrate
    @FunctionalInterface
    interface Function {
        double apply(double x);
    }

    // Method to apply Simpson's 3/8 rule for numerical integration
    public static double simpsons38Rule(Function f, double a, double b, int n) {
        if (n % 3 != 0) {
            throw new IllegalArgumentException("n must be a multiple of 3");
        }

        double h = (b - a) / n;
        double sum = f.apply(a) + f.apply(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 3 == 0) {
                sum += 2 * f.apply(x);
            } else {
                sum += 3 * f.apply(x);
            }
        }

        return (3.0 / 8.0) * h * sum;
    }

    public static void main(String[] args) {
        Function f = x -> Math.sin(x); // Example function f(x) = sin(x)
        double a = 0;
        double b = Math.PI;
        int n = 6; // Must be a multiple of 3
        System.out.println("Integral of sin(x) from " + a + " to " + b + " using Simpson's 3/8 rule: " +
                           simpsons38Rule(f, a, b, n));
    }
}


/* Application: Computing the power dissipated in a non-linear load
Problem: Calculate the power dissipated in a non-linear electrical load over a given time period.
If the power dissipation as a function of time P(t) is non-linear, you can use numerical integration 
to compute the total energy dissipated.
Example Problem: Given the power dissipation function P(t)=sin(t) over the interval [0,π], 
compute the total energy dissipated.
*/

public class PowerDissipation {

    public static void main(String[] args) {
        // Define the power dissipation function P(t) = sin(t)
        Function powerFunction = t -> Math.sin(t);
        
        double a = 0; // Start of the interval
        double b = Math.PI; // End of the interval
        int n = 6; // Number of intervals, must be a multiple of 3
        
        // Compute the total energy dissipated using Simpson's 3/8 rule
        double energyDissipated = simpsons38Rule(powerFunction, a, b, n);
        
        System.out.printf("Total energy dissipated: %.4f\n", energyDissipated);
    }

    // Functional interface for the function to integrate
    @FunctionalInterface
    interface Function {
        double apply(double x);
    }

    // Method to apply Simpson's 3/8 rule for numerical integration
    public static double simpsons38Rule(Function f, double a, double b, int n) {
        if (n % 3 != 0) {
            throw new IllegalArgumentException("n must be a multiple of 3");
        }

        double h = (b - a) / n;
        double sum = f.apply(a) + f.apply(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 3 == 0) {
                sum += 2 * f.apply(x);
            } else {
                sum += 3 * f.apply(x);
            }
        }

        return (3.0 / 8.0) * h * sum;
    }
}
