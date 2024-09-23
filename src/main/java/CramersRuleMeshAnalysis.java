import java.util.Scanner;

public class CramersRuleMeshAnalysis {

    // Function to calculate the determinant of a 3x3 matrix
    public static double determinant(double[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
               matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
               matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    // Function to replace a column in the matrix with the constant vector
    public static double[][] replaceColumn(double[][] matrix, double[] constants, int col) {
        double[][] newMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
            newMatrix[i][col] = constants[i];
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input for resistance values
        System.out.println("Enter the value of resistance R1 (Ohms): ");
        double R1 = scanner.nextDouble();
        System.out.println("Enter the value of resistance R2 (Ohms): ");
        double R2 = scanner.nextDouble();
        System.out.println("Enter the value of resistance R3 (Ohms): ");
        double R3 = scanner.nextDouble();
        System.out.println("Enter the value of resistance R4 (Ohms): ");
        double R4 = scanner.nextDouble();
        System.out.println("Enter the value of resistance R5 (Ohms): ");
        double R5 = scanner.nextDouble();

        // Prompt user for input for voltage values
        System.out.println("Enter the value of voltage V1 (Volts): ");
        double V1 = scanner.nextDouble();
        System.out.println("Enter the value of voltage V2 (Volts): ");
        double V2 = scanner.nextDouble();

        // Coefficients for the mesh current equations derived from the given circuit
        double[][] coefficients = {
            {(R1 + R2), -R2, 0},      // Equation 1: (R1 + R2)I1 - R2I2 = V1
            {-R2, (R2 + R3 + R4), -R4}, // Equation 2: -R2I1 + (R2 + R3 + R4)I2 - R4I3 = 0
            {0, -R4, (R4 + R5)}       // Equation 3: -R4I2 + (R4 + R5)I3 = V2
        };

        // Constants (voltage values)
        double[] constants = {V1, 0, V2};  // Corresponds to V1, 0 (since no source in loop 2), V2

        // Calculate the determinant of the coefficient matrix
        double detA = determinant(coefficients);

        if (detA == 0) {
            System.out.println("The system has no unique solution.");
        } else {
            // Calculate determinants for matrices with replaced columns
            double detI1 = determinant(replaceColumn(coefficients, constants, 0));
            double detI2 = determinant(replaceColumn(coefficients, constants, 1));
            double detI3 = determinant(replaceColumn(coefficients, constants, 2));

            // Solve for the mesh currents I1, I2, I3
            double I1 = detI1 / detA;
            double I2 = detI2 / detA;
            double I3 = detI3 / detA;

            // Output the mesh currents
            System.out.println("The currents in the circuit are:");
            System.out.println("I1 (Current in loop 1) = " + I1 + " A");
            System.out.println("I2 (Current in loop 2) = " + I2 + " A");
            System.out.println("I3 (Current in loop 3) = " + I3 + " A");
        }

        scanner.close();
    }
}
