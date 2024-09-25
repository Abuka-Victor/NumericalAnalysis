import java.util.Scanner;

public class HyperbolicFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of x:");
        double x = scanner.nextDouble();
        System.out.println("Enter the hyperbolic function to solve (1-6):");
        System.out.println("1. sinh(x)");
        System.out.println("2. cosh(x)");
        System.out.println("3. tanh(x)");
        System.out.println("4. coth(x)");
        System.out.println("5. sech(x)");
        System.out.println("6. csch(x)");
        int choice = scanner.nextInt();
        double result = 0;
        switch (choice) {
            case 1:
                result = sinh(x);
                break;
            case 2:
                result = cosh(x);
                break;
            case 3:
                result = tanh(x);
                break;
            case 4:
                result = coth(x);
                break;
            case 5:
                result = sech(x);
                break;
            case 6:
                result = csch(x);
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        System.out.println("Result: " + result);
    }

    public static double sinh(double x) {
        return (Math.exp(x) - Math.exp(-x)) / 2;
    }

    public static double cosh(double x) {
        return (Math.exp(x) + Math.exp(-x)) / 2;
    }

    public static double tanh(double x) {
        return sinh(x) / cosh(x);
    }

    public static double coth(double x) {
        return 1 / tanh(x);
    }

    public static double sech(double x) {
        return 1 / cosh(x);
    }

    public static double csch(double x) {
        return 1 / sinh(x);
    }
}