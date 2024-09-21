import java.util.Scanner;

public class RungeKutta {

    // Function to define the differential equation dy/dx = f(x, y)
    public static double f(double x, double y) {
        return x + y; // Given differential equation
    }

    // Function to perform the RK4 method
    public static double rungeKutta(double x0, double y0, double x, double h) {
        int n = (int)((x - x0) / h);
        double k1, k2, k3, k4;

        double y = y0;
        for (int i = 0; i < n; i++) {
            k1 = h * f(x0, y);
            k2 = h * f(x0 + 0.5 * h, y + 0.5 * k1);
            k3 = h * f(x0 + 0.5 * h, y + 0.5 * k2);
            k4 = h * f(x0 + h, y + k3);

            y = y + (1.0 / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
            x0 = x0 + h;
        }

        return y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial value of x (x0): ");
        double x0 = scanner.nextDouble();

        System.out.print("Enter initial value of y (y0): ");
        double y0 = scanner.nextDouble();

        System.out.print("Enter the value of x at which to find y: ");
        double x = scanner.nextDouble();

        System.out.print("Enter step size (h): ");
        double h = scanner.nextDouble();

        double result = rungeKutta(x0, y0, x, h);
        System.out.println("The value of y at x = " + x + " is " + result);
    }
}
