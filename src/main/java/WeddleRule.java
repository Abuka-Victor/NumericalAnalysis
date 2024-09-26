public class WeddleRule {

    // Function to be integrated
    public static double f(double x) {
        // Example function: f(x) = x^2
        return x * x;
    }

    // Weddle's Rule implementation
    public static double weddleRule(double a, double b, int n) {
        // Ensure that the number of intervals (n) is a multiple of 6
        if (n % 6 != 0) {
            System.out.println("Number of intervals must be a multiple of 6.");
            return -1;
        }

        double h = (b - a) / n;
        double sum = 0.0;

        for (int i = 0; i <= n - 6; i += 6) {
            double x0 = a + i * h;
            double x1 = x0 + h;
            double x2 = x0 + 2 * h;
            double x3 = x0 + 3 * h;
            double x4 = x0 + 4 * h;
            double x5 = x0 + 5 * h;
            double x6 = x0 + 6 * h;

            sum += (h / 3) * (f(x0) + 5 * f(x1) + f(x2) + 6 * f(x3) + f(x4) + 5 * f(x5) + f(x6));
        }

        return (3 * sum) / 10;
    }

    public static void main(String[] args) {
        double a = 0;  // Lower limit of integration
        double b = 6;  // Upper limit of integration
        int n = 6;     // Number of intervals (must be a multiple of 6)

        double result = weddleRule(a, b, n);

        if (result != -1) {
            System.out.println("The approximate value of the integral is: " + result);
        }
    }
}