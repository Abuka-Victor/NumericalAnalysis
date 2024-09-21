import java.util.Scanner;

public class JacobiEigenvalues {

    // Function to perform Jacobi's method for eigenvalues and eigenvectors
    public static void jacobiMethod(double[][] A, double[] eigenvalues, double[][] eigenvectors, int maxIterations, double tolerance) {
        int n = A.length;
        double[][] V = new double[n][n];
        for (int i = 0; i < n; i++) {
            V[i][i] = 1.0;
        }

        for (int iter = 0; iter < maxIterations; iter++) {
            int p = 0, q = 1;
            double max = Math.abs(A[p][q]);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (Math.abs(A[i][j]) > max) {
                        max = Math.abs(A[i][j]);
                        p = i;
                        q = j;
                    }
                }
            }

            if (max < tolerance) break;

            double theta = 0.5 * Math.atan2(2 * A[p][q], A[q][q] - A[p][p]);
            double cos = Math.cos(theta);
            double sin = Math.sin(theta);

            for (int i = 0; i < n; i++) {
                double temp = V[i][p];
                V[i][p] = cos * temp - sin * V[i][q];
                V[i][q] = sin * temp + cos * V[i][q];
            }

            double app = cos * cos * A[p][p] - 2 * sin * cos * A[p][q] + sin * sin * A[q][q];
            double aqq = sin * sin * A[p][p] + 2 * sin * cos * A[p][q] + cos * cos * A[q][q];
            A[p][q] = 0.0;
            A[q][p] = 0.0;
            A[p][p] = app;
            A[q][q] = aqq;

            for (int i = 0; i < n; i++) {
                if (i != p && i != q) {
                    double aip = cos * A[i][p] - sin * A[i][q];
                    double aiq = sin * A[i][p] + cos * A[i][q];
                    A[i][p] = aip;
                    A[p][i] = aip;
                    A[i][q] = aiq;
                    A[q][i] = aiq;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            eigenvalues[i] = A[i][i];
            for (int j = 0; j < n; j++) {
                eigenvectors[i][j] = V[j][i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the matrix: ");
        int n = scanner.nextInt();

        double[][] A = new double[n][n];
        System.out.println("Enter the elements of the symmetric matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextDouble();
            }
        }

        double[] eigenvalues = new double[n];
        double[][] eigenvectors = new double[n][n];

        System.out.print("Enter the maximum number of iterations: ");
        int maxIterations = scanner.nextInt();

        System.out.print("Enter the tolerance for convergence: ");
        double tolerance = scanner.nextDouble();

        jacobiMethod(A, eigenvalues, eigenvectors, maxIterations, tolerance);

        System.out.println("Eigenvalues:");
        for (double eigenvalue : eigenvalues) {
            System.out.println(eigenvalue);
        }

        System.out.println("Eigenvectors:");
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                System.out.print(eigenvectors[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
