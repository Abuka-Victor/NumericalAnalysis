public class PowerFlowNewtonRaphson {
    // Define the active power equation P2(V2, theta2)
    public static double powerEquation(double V2, double theta2, double V1, double P2, double G21, double B21) {
        return V2 * (V1 * (G21 * Math.cos(theta2) + B21 * Math.sin(theta2))) - P2;
    }

    // Define the derivative of the power equation with respect to V2
    public static double derivativeV2(double theta2, double V1, double G21, double B21) {
        return V1 * (G21 * Math.cos(theta2) + B21 * Math.sin(theta2));
    }

    // Define the derivative of the power equation with respect to theta2
    public static double derivativeTheta2(double V2, double V1, double G21, double B21) {
        return V2 * V1 * (-G21 * Math.sin(theta2) + B21 * Math.cos(theta2));
    }

    // Newton-Raphson method implementation for power flow
    public static double[] newtonRaphson(double V2, double theta2, double V1, double P2, double G21, double B21, double tolerance) {
        double deltaP = powerEquation(V2, theta2, V1, P2, G21, B21);
        while (Math.abs(deltaP) >= tolerance) {
            double dV2 = derivativeV2(theta2, V1, G21, B21);
            double dTheta2 = derivativeTheta2(V2, V1, G21, B21);
            V2 = V2 - deltaP / dV2;
            theta2 = theta2 - deltaP / dTheta2;
            deltaP = powerEquation(V2, theta2, V1, P2, G21, B21);
        }
        return new double[]{V2, theta2};
    }

    public static void main(String[] args) {
        double V1 = 1.0; // Voltage at Bus 1 (slack bus)
        double P2 = 1.5; // Active power at Bus 2
        double G21 = 0.01; // Conductance between Bus 2 and Bus 1
        double B21 = -0.05; // Susceptance between Bus 2 and Bus 1
        double V2 = 1.0; // Initial guess for voltage magnitude at Bus 2
        double theta2 = 0.0; // Initial guess for voltage angle at Bus 2
        double tolerance = 0.0001; // Tolerance for convergence

        double[] result = newtonRaphson(V2, theta2, V1, P2, G21, B21, tolerance);
        System.out.println("The voltage magnitude at Bus 2 is: " + result[0]);
        System.out.println("The voltage angle at Bus 2 is: " + result[1] + " radians");
    }
}
