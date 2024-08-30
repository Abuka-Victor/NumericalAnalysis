import java.util.Scanner;

// Additive method (error propagation)
public class ErrorPropagation {

    // Method to calculate propagated error for addition/subtraction
    public static double calculatePropagatedError(double[] errors) {
        double sumOfSquares = 0.0;

        for (double error : errors) {
            sumOfSquares += Math.pow(error, 2);
        }

        return Math.sqrt(sumOfSquares);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of measurements
        System.out.print("Enter the number of measurements: ");
        int n = scanner.nextInt();

        double[] values = new double[n];
        double[] errors = new double[n];

        // Input values and their uncertainties
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the value of measurement " + (i + 1) + ": ");
            values[i] = scanner.nextDouble();

            System.out.print("Enter the uncertainty of measurement " + (i + 1) + ": ");
            errors[i] = scanner.nextDouble();
        }

        // Calculate the result (sum of values) and the propagated error
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }

        double propagatedError = calculatePropagatedError(errors);

        // Output the result and the propagated error
        System.out.println("Result (sum of values): " + sum);
        System.out.println("Propagated Error: " + propagatedError);

        scanner.close();
    }
}
