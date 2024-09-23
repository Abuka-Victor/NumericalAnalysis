import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of R: ");
        double R = scanner.nextDouble();

        System.out.print("Enter the value of C: ");
        double C = scanner.nextDouble();

        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();

        System.out.print("Enter the value of t: ");
        double t = scanner.nextDouble();

        double Voltage = calculateTaylorSeries(R, C, n, t);
        System.out.println("Voltage using Taylor series expansion= " + Voltage);
    }

    public static double calculateTaylorSeries(double R, double C, int n, double t) {
        double Voltage = 0;
        for (int i = 0; i <= n; i++) {
            double term = calculateTerm(R, C, i, t);
            Voltage += term;
        }
        return Voltage;
    }

    public static double calculateTerm(double R, double C, int i, double t) {
        double coefficient = 10 * Math.pow(-1, i) / factorial(i);
        double exponent = i / (R * C);
        return coefficient * Math.pow(t, i) / Math.pow(R * C, exponent);
    }

    public static int factorial(int n) {
        int Voltage = 1;
        for (int i = 1; i <= n; i++) {
            Voltage *= i;
        }
        return Voltage;
    }
}