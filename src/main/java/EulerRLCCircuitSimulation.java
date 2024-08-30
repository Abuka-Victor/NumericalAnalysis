public class EulerRLCCircuitSimulation {
    // Circuit parameters
    static double R = 10; // Resistance in ohms
    static double L = 0.5; // Inductance in henries
    static double C = 0.001; // Capacitance in farads
    static double V = 10; // Step voltage in volts

    // Euler's Method to simulate the current in an RLC circuit
    public static double[] euler(double h, int steps) {
        double[] current = new double[steps + 1];
        double[] voltage = new double[steps + 1];
        double[] di_dt = new double[steps + 1];
        current[0] = 0.0; // Initial current
        voltage[0] = V; // Initial voltage

        for (int i = 0; i < steps; i++) {
            di_dt[i] = (voltage[i] / L) - (R / L) * current[i] - (1 / (L * C)) * current[i];
            current[i + 1] = current[i] + h * di_dt[i];
            voltage[i + 1] = voltage[i]; // Assuming constant step voltage
        }
        return current;
    }

    public static void main(String[] args) {
        double h = 0.01; // Time step size in seconds
        int steps = 100; // Number of steps for simulation
        double[] current = euler(h, steps);

        System.out.println("Current in the RLC circuit over time:");
        for (int i = 0; i < current.length; i++) {
            System.out.println("At time " + (i * h) + " s: " + current[i] + " A");
        }
    }
}
