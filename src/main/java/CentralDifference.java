public class CentralDifference {
    // Function to approximate the derivative of
    public static double function(double x) {
        return Math.sin(x); // Example function: sin(x)
    }

    // Central difference method for first derivative
    public static double centralDifference(double x, double h) {
        return (function(x + h) - function(x - h)) / (2 * h);
    }

    public static void main(String[] args) {
        double x = Math.PI / 4; // Point at which derivative is calculated
        double h = 1e-5; // Small step size

        double derivative = centralDifference(x, h);
        System.out.println("The derivative of the function at x = " + x + " is approximately: " + derivative);
    }
}