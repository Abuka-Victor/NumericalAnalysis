import java.util.Scanner;
//implementation for booles rule
public class BoolesRule {

    public static double boolesRule(double a, double b, int n, Function f) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the lower limit of integration (a): ");
        double a = scanner.nextDouble();

        System.out.print("Enter the upper limit of integration (b): ");
        double b = scanner.nextDouble();

        System.out.print("Enter the number of subintervals (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter the function to integrate (1 for x^2, 2 for x^3, 3 for e^x): ");
        int choice = scanner.nextInt();

        Function f = getFunction(choice);

        double result = boolesRule(a, b, n, f);
        System.out.println("Approximate integral: " + result);
    }

    private static Function getFunction(int choice) {
        switch (choice) {
            case 1:
                return x -> x * x; // x^2
            case 2:
                return x -> x * x * x; // x^3
            case 3:
                return Math::exp; // e^x
            default:
                return x -> 0; // default function
        }
    }
}

interface Function {
    double evaluate(double x);
}