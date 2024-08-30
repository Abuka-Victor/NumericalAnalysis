import java.util.function.Function;
import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PicardMethod {
    // Function representing dy/dx = f(x, y)
    static Function<Double, Double> f = (y) -> 1 + y * y;

    // Picard's iterative method
    public static double picardIteration(double x0, double y0, double x, int n) {
        double y = y0;
        for (int i = 0; i < n; i++) {
            y = y0 + integrate(x0, x, y);
        }
        return y;
    }

    // Numerical integration using the trapezoidal rule
    public static double integrate(double x0, double x, double y) {
        int steps = 1000; // Number of steps for integration
        double h = (x - x0) / steps;
        double sum = 0.5 * (f.apply(y) + f.apply(y + h));
        for (int i = 1; i < steps; i++) {
            sum += f.apply(y + i * h);
        }
        return h * sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial value of x (x0): ");
        double x0 = scanner.nextDouble();

        System.out.print("Enter initial value of y (y0): ");
        double y0 = scanner.nextDouble();

        System.out.print("Enter the value of x at which to approximate y: ");
        double x = scanner.nextDouble();

        System.out.print("Enter the number of iterations: ");
        int iterations = scanner.nextInt();

        double result = picardIteration(x0, y0, x, iterations);
        System.out.printf("Approximate solution at x = %.2f is y = %.4f%n", x, result);
    }
}