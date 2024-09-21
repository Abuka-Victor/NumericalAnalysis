import java.util.Scanner;

public class SignalProcessing {
    // Estimating Rate of Change in Digital Signal Processing using the forwardDifference formula 

    public static double signalFunction(double t) {
        // Example signal: s(t) = sin(t)
        return Math.sin(t);
    }

    public static double forwardDifference(double t, double h) {
        return (signalFunction(t + h) - signalFunction(t)) / h;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting the user for input
        System.out.print("Enter the time point (t) in radians: ");
        double time = scanner.nextDouble();

        System.out.print("Enter the step size (h): ");
        double h = scanner.nextDouble();

        // Calculate the derivative using the forward difference method
        double derivative = forwardDifference(time, h);
        System.out.println("The derivative of the signal at t = " + time + " is approximately: " + derivative);

        scanner.close();
    }
}
