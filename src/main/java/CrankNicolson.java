public class CrankNicolson {
  public static void main(String[] args) {
    int N = 10; // number of grid points
    int M = 10; // number of time steps
    double dt = 0.1; // time step size
    double dx = 1.0 / N; // grid size
    double[] U = new double[N]; // solution array
    double[] F = new double[N]; // function array

    // Initialize solution and function arrays
    for (int i = 0; i < N; i++) {
      U[i] = Math.sin(Math.PI * i * dx);
      F[i] = Math.sin(Math.PI * i * dx);
    }

    // Time-stepping loop
    for (int n = 0; n < M; n++) {
      for (int i = 1; i < N - 1; i++) {
        U[i] = U[i] + (dt / 2) * (F[i + 1] - 2 * F[i] + F[i - 1]) / (dx * dx);
      }
    }

    // Print solution
    for (int i = 0; i < N; i++) {
      System.out.println(U[i]);
    }
  }
}