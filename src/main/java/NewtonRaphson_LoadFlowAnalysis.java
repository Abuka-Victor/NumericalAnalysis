import java.util.Scanner;

public class LoadFlowAnalysis {

    public static double powerEquation(double V, double theta) {
		// Using Newton-Raphson method to perform Load Flow Analysis
        // Simplified power equation for demonstration: P(V, θ) = V*sin(θ) - 1
        return V * Math.sin(theta) - 1;
    }

    public static double powerEquationDerivative(double V, double theta) {
        // Derivative with respect to θ: dP/dθ = V*cos(θ)
        return V * Math.cos(theta);
    }

    public static double newtonRaphson(double initialGuess, double V, double tolerance, int maxIterations) {
        double theta = initialGuess;
        int iteration = 0;

        while (Math.abs(powerEquation(V, theta)) > tolerance && iteration < maxIterations) {
            theta = theta - powerEquation(V, theta) / powerEquationDerivative(V, theta);
            iteration++;
        }

        return theta;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting the user for input
        System.out.print("Enter the initial guess for the voltage angle (in radians): ");
        double initialGuess = scanner.nextDouble();

        System.out.print("Enter the voltage magnitude (in p.u.): ");
        double voltageMagnitude = scanner.nextDouble();

        System.out.print("Enter the tolerance for convergence: ");
        double tolerance = scanner.nextDouble();

        System.out.print("Enter the maximum number of iterations: ");
        int maxIterations = scanner.nextInt();

        // Calculate the voltage angle using the Newton-Raphson method
        double voltageAngle = newtonRaphson(initialGuess, voltageMagnitude, tolerance, maxIterations);
        System.out.println("The voltage angle is: " + voltageAngle + " radians");

        scanner.close();
    }
}
