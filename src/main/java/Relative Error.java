import java.util.Scanner;

public class Main{

    /**
     * Calculates relative error
     *
     * @param measuredValue measured value
     * @param trueValue     true value
     * @return relative error
     */
    public static double calculateRelativeError(double measuredValue, double trueValue) {
        if (trueValue == 0) {
            throw new ArithmeticException("True value cannot be zero");
        }
        return Math.abs((measuredValue - trueValue) / trueValue) * 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter true value (V): ");
        double trueValue = scanner.nextDouble();

        System.out.print("Enter measured value (V): ");
        double measuredValue = scanner.nextDouble();

        // Calculate relative error
        double relativeError = calculateRelativeError(measuredValue, trueValue);

        // Display result
        System.out.printf("Relative Error: %.2f%%\n", relativeError);
    }
}