import java.util.Scanner;

public class EverettInterpolation {

    // Function to calculate factorial
    public static int factorial(int n) {
        if (n == 0) return 1;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Function to calculate finite differences
    public static double[] calculateFiniteDifferences(double[] y) {
        int n = y.length;
        double[] delta = new double[n];
        System.arraycopy(y, 0, delta, 0, n);

        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                delta[j] = delta[j] - delta[j - 1];
            }
        }
        return delta;
    }

    // Function to calculate Everett's interpolation
    public static double everettInterpolation(double[] x, double[] y, double t) {
        int n = x.length;
        double h = x[1] - x[0]; // Assuming equally spaced points
        double u = (t - x[0]) / h;
        double result = 0.0;

        // Calculate finite differences
        double[] delta = calculateFiniteDifferences(y);

        // Apply Everett's formula
        result = delta[0];
        double term = 1.0;
        for (int i = 1; i < n; i++) {
            term *= (u - (i - 1)) / i;
            result += term * delta[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of data points: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Enter the x values:");
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
        }

        System.out.println("Enter the y values:");
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextDouble();
        }

        System.out.print("Enter the value of t to interpolate: ");
        double t = scanner.nextDouble();

        double interpolatedValue = everettInterpolation(x, y, t);
        System.out.println("Interpolated value at x = " + t + " is " + interpolatedValue);
    }
}
