import java.util.Scanner;
//code for the implementation of quotient property(error propagation)
//the code will propmpt for input
public class QuotientErrorPropagation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dividend (x): ");
        double x = scanner.nextDouble();

        System.out.print("Enter the error in the dividend (Δx): ");
        double deltaX = scanner.nextDouble();

        System.out.print("Enter the divisor (y): ");
        double y = scanner.nextDouble();

        System.out.print("Enter the error in the divisor (Δy): ");
        double deltaY = scanner.nextDouble();

        double quotient = x / y;
        double errorInQuotient = calculateErrorInQuotient(x, y, deltaX, deltaY);

        System.out.println("Quotient: " + quotient);
        System.out.println("Error in Quotient: " + errorInQuotient);
    }

    private static double calculateErrorInQuotient(double x, double y, double deltaX, double deltaY) {
        double relativeErrorInX = deltaX / x;
        double relativeErrorInY = deltaY / y;

        return Math.sqrt(Math.pow(relativeErrorInX, 2) + Math.pow(relativeErrorInY, 2));
    }
}