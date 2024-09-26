public class LinearIteration {

    // Function whose root we want to find (f(x) = 0)
    public static double f(double x) {
        // Example function: f(x) = x^2 - 4
        return x * x - 4;
    }

    // Rearranged function g(x) = x for linear iteration (x = sqrt(4))
    public static double g(double x) {
        // g(x) = sqrt(4) => g(x) = 2
        return Math.sqrt(4);
    }

    // Linear Iteration method
    public static double linearIteration(double initialGuess, double tolerance, int maxIterations) {
        double x = initialGuess;
        double xNew;
        int iteration = 0;

        while (iteration < maxIterations) {
            xNew = g(x);
            
            // Check for convergence
            if (Math.abs(xNew - x) < tolerance) {
                return xNew;
            }
            
            x = xNew;
            iteration++;
        }

        // If the loop exits, it means the method did not converge within the maximum iterations
        System.out.println("The method did not converge within the maximum number of iterations.");
        return x;
    }

    public static void main(String[] args) {
        double initialGuess = 1.0;     // Initial guess
        double tolerance = 1e-6;       // Tolerance level
        int maxIterations = 1000;      // Maximum number of iterations

        double root = linearIteration(initialGuess, tolerance, maxIterations);

        System.out.println("The approximate root is: " + root);
    }
}