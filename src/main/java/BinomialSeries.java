import java.util.Scanner;
//this code is to solve a general problem using binomial series
public class BinomialSeries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the value of b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter the value of n: ");
        double n = scanner.nextDouble();

        System.out.print("Enter the number of terms: ");
        int terms = scanner.nextInt();

        double result = calculateBinomialSeries(a, b, n, terms);

        System.out.println("Approximate value of (a + b)^n: " + result);
    }

    private static double calculateBinomialSeries(double a, double b, double n, int terms) {
        double result = 0;

        for (int i = 0; i <= terms; i++) {
            result += Math.pow(a, n - i) * Math.pow(b, i) * factorial(n) / (factorial(i) * factorial(n - i));
        }

        return result;
    }

    private static double factorial(double n) {
        double result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}