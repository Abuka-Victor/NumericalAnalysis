import java.util.Scanner;
//code for the application of binomial series
public class TransmissionLineAttenuation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the characteristic impedance (Z0) in ohms: ");
        double Z0 = scanner.nextDouble();

        System.out.print("Enter the propagation constant (γ) in dB/m: ");
        double gamma = scanner.nextDouble();

        System.out.print("Enter the frequency (f) in MHz: ");
        double frequency = scanner.nextDouble();

        System.out.print("Enter the length (L) in meters: ");
        double length = scanner.nextDouble();

        System.out.print("Enter the number of terms (n) for the binomial series: ");
        int terms = scanner.nextInt();

        double attenuation = calculateAttenuation(gamma, length, terms);

        System.out.println("Approximate attenuation after " + length + " meters: " + attenuation + " dB");
    }

    private static double calculateAttenuation(double gamma, double length, int terms) {
        double attenuation = 0;

        for (int i = 0; i <= terms; i++) {
            attenuation += Math.pow(-1, i) * Math.pow(gamma * length, 2 * i) / (2 * i + 1);
        }

        return attenuation;
    }
}