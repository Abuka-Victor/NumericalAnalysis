import java.util.Scanner;

public class AbsoluteErrorCalculator {

    // Function to calculate absolute error
    public static double calculateAbsoluteError(double trueValue, double measuredValue) {
        return Math.abs(trueValue - measuredValue);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the true value: ");
        double trueValue = scanner.nextDouble();

        System.out.print("Enter the measured value: ");
        double measuredValue = scanner.nextDouble();

        double absoluteError = calculateAbsoluteError(trueValue, measuredValue);
        System.out.println("The absolute error is: " + absoluteError);
    }
}
