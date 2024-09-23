
import java.util.Scanner;
// solving a problem with booles rule
public class BoolesCircuitanalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the resistance (R): ");
        double R = scanner.nextDouble();

        System.out.print("Enter the inductance (L): ");
        double L = scanner.nextDouble();

        System.out.print("Enter the voltage function (1 for sin(2πt), 2 for cos(2πt), 3 for e^(-t)): ");
        int choice = scanner.nextInt();

        VoltageFunction voltageFunction = getVoltageFunction(choice);

        double energy = calculateEnergy(R, L, voltageFunction);

        System.out.println("Approximate total energy dissipated: " + energy + " J");
    }

    private static VoltageFunction getVoltageFunction(int choice) {
        switch (choice) {
            case 1:
                return t -> 100 * Math.sin(2 * Math.PI * t);
            case 2:
                return t -> 100 * Math.cos(2 * Math.PI * t);
            case 3:
                return t -> 100 * Math.exp(-t);
            default:
                return t -> 0;
        }
    }

    private static double calculateEnergy(double R, double L, VoltageFunction voltageFunction) {
        int n = 4;
        double h = 0.5;
        double sum = 0;

        for (int i = 0; i <= n; i++) {
            double t = i * h;
            double coefficient;

            if (i == 0 || i == n) {
                coefficient = 7;
            } else if (i % 4 == 0) {
                coefficient = 12;
            } else {
                coefficient = 32;
            }

            double v = voltageFunction.evaluate(t);
            double i = (1 / L) * boolesRule(0, t, n, x -> v);
            sum += coefficient * i * i * R;
        }

        return (2 * h / 45) * sum;
    }

    private static double boolesRule(double a, double b, int n, Function f) {
        double h = (b - a) / n;
        double sum = 0;

        for (int i = 0; i <= n; i++) {
            double x = a + i * h;
            double coefficient;

            if (i == 0 || i == n) {
                coefficient = 7;
            } else if (i % 4 == 0) {
                coefficient = 12;
            } else {
                coefficient = 32;
            }

            sum += coefficient * f.evaluate(x);
        }

        return (2 * h / 45) * sum;
    }

    interface Function {
        double evaluate(double x);
    }

    interface VoltageFunction {
        double evaluate(double t);
    }
}