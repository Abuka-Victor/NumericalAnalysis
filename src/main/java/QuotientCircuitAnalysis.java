
import java.util.Scanner;
//this code is to solve a problem using quetient property(error propagation)
public class QuotientCircuitAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the resistance (R) in ohms: ");
        double R = scanner.nextDouble();

        System.out.print("Enter the error in resistance (ΔR) in %: ");
        double deltaR = scanner.nextDouble() / 100;

        System.out.print("Enter the capacitance (C) in farads: ");
        double C = scanner.nextDouble();

        System.out.print("Enter the error in capacitance (ΔC) in %: ");
        double deltaC = scanner.nextDouble() / 100;

        System.out.print("Enter the frequency in hertz: ");
        double frequency = scanner.nextDouble();

        double impedance = calculateImpedance(R, C, frequency);
        double errorInImpedance = calculateErrorInImpedance(R, deltaR, C, deltaC);

        System.out.println("Impedance: " + impedance + " ohms");
        System.out.println("Error in Impedance: " + errorInImpedance + " (%)");
    }

    private static double calculateImpedance(double R, double C, double frequency) {
        double omega = 2 * Math.PI * frequency;
        return Math.sqrt(Math.pow(R, 2) + Math.pow(1 / (omega * C), 2));
    }

    private static double calculateErrorInImpedance(double R, double deltaR, double C, double deltaC) {
        return Math.sqrt(Math.pow(deltaR, 2) + Math.pow(deltaC, 2)) * 100;
    }
}
