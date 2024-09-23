public class Main {
    public static void main(String[] args) {
        double s = 3; // value of s
        double a = 2; // coefficient of t^2
        double b = 3; // coefficient of t
        double c = 1; // constant term

        double result = computeLaplaceTransform(a, b, c, s);
        System.out.println("The Laplace transform of the function 2t^2 + 3t + 1 for s = " + s + " is: " + result);
    }

    public static double computeLaplaceTransform(double a, double b, double c, double s) {
        // Laplace transform of t^n is n! / s^(n+1)
        // So, Laplace transform of 2t^2 is 2*2! / s^3
        double transformOfATSquared = (2 * factorial(2)) / Math.pow(s, 3);

        // Laplace transform of t^n is n! / s^(n+1)
        // So, Laplace transform of 3t is 3*1! / s^2
        double transformOfBT = (3 * factorial(1)) / Math.pow(s, 2);

        // Laplace transform of a constant c is c / s
        double transformOfC = c / s;

        return transformOfATSquared + transformOfBT + transformOfC;
    }

    public static double factorial(int n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}