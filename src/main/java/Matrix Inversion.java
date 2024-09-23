public class Main {

    public static void main(String[] args) {
        // Define impedance matrix Z
        double[][] Z = {
            {5, 2, 1},
            {2, 4, 3},
            {1, 3, 6}
        };

        // Define voltage vector V
        double[] V = {10, 20, 30};

        // Invert matrix Z
        double[][] Zinv = invertMatrix(Z);

        // Calculate current vector I
        double[] I = multiplyMatrixVector(Zinv, V);

        // Print results
        System.out.println("Impedance Matrix (Z):");
        printMatrix(Z);
        System.out.println("Voltage Vector (V):");
        printVector(V);
        System.out.println("Inverted Matrix (Z^-1):");
        printMatrix(Zinv);
        System.out.println("Current Vector (I):");
        printVector(I);
    }

    // Method to invert matrix
    public static double[][] invertMatrix(double[][] matrix) {
        int n = matrix.length;
        double[][] inverse = new double[n][n];

        // Use Gauss-Jordan elimination
        double[][] augmentedMatrix = augmentMatrix(matrix);
        gaussJordanElimination(augmentedMatrix);

        // Extract inverse matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return inverse;
    }

    // Method to augment matrix
    public static double[][] augmentMatrix(double[][] matrix) {
        int n = matrix.length;
        double[][] augmentedMatrix = new double[n][2 * n];

        // Copy original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
            }
        }

        // Add identity matrix
        for (int i = 0; i < n; i++) {
            augmentedMatrix[i][i + n] = 1;
        }

        return augmentedMatrix;
    }

    // Method for Gauss-Jordan elimination
    public static void gaussJordanElimination(double[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            // Partial pivoting
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matrix[k][i]) > Math.abs(matrix[maxRow][i])) {
                    maxRow = k;
                }
            }

            // Swap rows
            double[] temp = matrix[i];
            matrix[i] = matrix[maxRow];
            matrix[maxRow] = temp;

            // Make pivot 1
            double pivot = matrix[i][i];
            for (int j = 0; j < 2 * n; j++) {
                matrix[i][j] /= pivot;
            }

            // Eliminate pivot column
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        matrix[k][j] -= factor * matrix[i][j];
                    }
                }
            }
        }
    }

    // Method to multiply matrix and vector
    public static double[] multiplyMatrixVector(double[][] matrix, double[] vector) {
        int n = matrix.length;
        double[] result = new double[n];

        for (int i = 0; i < n; i++) {
            result[i] = 0;
            for (int j = 0; j < n; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }

        return result;
    }

    // Method to print matrix
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // Method to print vector
    public static void printVector(double[] vector) {
        for (double element : vector) {
            System.out.println(element);
        }
    }
}