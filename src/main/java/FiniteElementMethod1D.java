import java.util.Arrays;

public class FiniteElementMethod1D {

    // Number of nodes
    static int N = 10; 
    static double[] x = new double[N + 1];  // Node positions
    static double[] u = new double[N + 1];  // Solution vector (displacements)
    static double[] f = new double[N + 1];  // Source term
    
    static double[][] K = new double[N + 1][N + 1];  // Stiffness matrix

    // Mesh size
    static double L = 1.0;  // Length of the domain
    static double h = L / N;  // Element size

    // Source term function
    public static double sourceTerm(double x) {
        return 1.0;  // Constant source term for simplicity
    }

    // Assemble stiffness matrix and force vector
    public static void assembleSystem() {
        // Loop through elements
        for (int i = 0; i < N; i++) {
            // Local stiffness matrix for a linear element
            double[][] Ke = {
                {1.0 / h, -1.0 / h},
                {-1.0 / h, 1.0 / h}
            };

            // Local force vector
            double[] Fe = {
                h / 2 * sourceTerm(x[i]),
                h / 2 * sourceTerm(x[i + 1])
            };

            // Global assembly into K and f
            K[i][i] += Ke[0][0];
            K[i][i + 1] += Ke[0][1];
            K[i + 1][i] += Ke[1][0];
            K[i + 1][i + 1] += Ke[1][1];

            f[i] += Fe[0];
            f[i + 1] += Fe[1];
        }
    }

    // Apply boundary conditions (Dirichlet at x=0, Neumann at x=L)
    public static void applyBoundaryConditions() {
        // Dirichlet boundary condition u(0) = 0
        K[0][0] = 1.0;
        K[0][1] = 0.0;
        f[0] = 0.0;

        // Neumann boundary condition at x=L is already handled implicitly
    }

    // Solve system using Gaussian elimination (simplified for demonstration)
    public static void solve() {
        for (int i = 0; i < N; i++) {
            double factor = K[i][i];
            for (int j = i; j <= N; j++) {
                K[i][j] /= factor;
            }
            f[i] /= factor;

            for (int k = i + 1; k <= N; k++) {
                double factor2 = K[k][i];
                for (int j = i; j <= N; j++) {
                    K[k][j] -= factor2 * K[i][j];
                }
                f[k] -= factor2 * f[i];
            }
        }

        // Back substitution
        u[N] = f[N];
        for (int i = N - 1; i >= 0; i--) {
            u[i] = f[i];
            for (int j = i + 1; j <= N; j++) {
                u[i] -= K[i][j] * u[j];
            }
        }
    }

    // Initialize the mesh
    public static void initializeMesh() {
        for (int i = 0; i <= N; i++) {
            x[i] = i * h;
        }
    }

    // Display the results
    public static void displayResults() {
        System.out.println("Node positions: " + Arrays.toString(x));
        System.out.println("Solution (u): " + Arrays.toString(u));
    }

    public static void main(String[] args) {
        initializeMesh();
        assembleSystem();
        applyBoundaryConditions();
        solve();
        displayResults();
    }
}