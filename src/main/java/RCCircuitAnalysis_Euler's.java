import java.util.Scanner;

public class RCCircuitAnalysis {

    public static double rcCircuitFunction(double v, double Vin, double R, double C) {
        // Using Euler's method to solve Transient Analysis of an RC Circuit
        // dv/dt = (Vin - v) / (RC)
        return (Vin - v) / (R * C);
    }

    /**
     * Euler's Method:
     * v(t + h) = v(t) + h * (dv/dt)
     * where dv/dt = (Vin - v) / (R * C)
     */
    public static double[] eulerMethod(double Vin, double R, double C, double v0, double h, int steps) {
        double[] voltage = new double[steps + 1];
        double v = v0;

        for (int i = 0; i <= steps; i++) {
            voltage[i] = v;
            v = v + h * rcCircuitFunction(v, Vin, R, C);
        }

        return voltage;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting the user for input
        System.out.print("Enter the step input voltage (Vin) in volts: ");
        double Vin = scanner.nextDouble();

        System.out.print("Enter the resistance (R) in ohms: ");
        double R = scanner.nextDouble();

        System.out.print("Enter the capacitance (C) in farads: ");
        double C = scanner.nextDouble();

        System.out.print("Enter the initial voltage across the capacitor (v0) in volts: ");
        double v0 = scanner.nextDouble();

        System.out.print("Enter the time step size (h): ");
        double h = scanner.nextDouble();

        System.out.print("Enter the number of steps: ");
        int steps = scanner.nextInt();

        // Calculate the voltage across the capacitor using Euler's method
        double[] voltages = eulerMethod(Vin, R, C, v0, h, steps);

        // Print the results
        for (int i = 0; i <= steps; i++) {
            System.out.println("Step " + i + ": Voltage across capacitor = " + voltages[i] + " V");
        }

        scanner.close();
    }
}
