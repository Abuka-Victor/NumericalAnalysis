public class StirlingInterpolation {

    public static double function(double x) {
        // Example function: f(x) = x^2
        return x * x;
    }

    public static double firstDerivative(double x, double h) {
        return (function(x + h) - function(x - h)) / (2 * h);
    }

    public static double secondDerivative(double x, double h) {
        return (function(x + h) - 2 * function(x) + function(x - h)) / (h * h);
    }

    public static void main(String[] args) {
        double x = 2.0; // Point at which to differentiate
        double h = 0.01; // Small increment

        double firstDeriv = firstDerivative(x, h);
        double secondDeriv = secondDerivative(x, h);

        System.out.println("First derivative at x = " + x + " is: " + firstDeriv);
        System.out.println("Second derivative at x = " + x + " is: " + secondDeriv);
    }
}

// Application of the Stirling's Interpolation Formula
public class SignalProcessing {

    // Example signal function: f(t) = sin(t)
    public static double signalFunction(double t) {
        return Math.sin(t);
    }

    // First derivative using Stirling's interpolation (central difference)
    public static double firstDerivative(double t, double h) {
        return (signalFunction(t + h) - signalFunction(t - h)) / (2 * h);
    }

    public static void main(String[] args) {
        // Define the sampling point and increment
        double t = Math.PI / 4; // Sampling point (45 degrees)
        double h = 0.01; // Small increment

        // Estimate the first derivative
        double derivative = firstDerivative(t, h);

        // Output the result
        System.out.println("Estimated first derivative of the signal at t = " + t + " is: " + derivative);
    }
}
