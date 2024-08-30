
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.objecthunter.exp4j.*;

public class Newton {
	
	 static int factorial(int n) {
	        int fact = 1;
	        for (int i = 2; i <= n; i++) {
	            fact *= i;
	        }
	        return fact;
	    }

	    // Function to calculate u based on n and x
	    static double calculateUForward(double u, int n) {
	        double result = u;
	        for (int i = 1; i < n; i++) {
	            result *= (u - i);
	        }
	        return result;
	    }
	    
	    static double calculateUBackward(double u, int n) {
	        double result = u;
	        for (int i = 1; i < n; i++) {
	            result *= (u + i);
	        }
	        return result;
	    }
	   
	
	 public static double newtonForward(double x[], double y[][], double value, int n) {
	        double sum = y[0][0];
	        double u = (value - x[0]) / (x[1] - x[0]);

	        for (int i = 1; i < n; i++) {
	            sum += (calculateUForward(u, i) * y[0][i]) / factorial(i);
	        }

	        return sum;
	    }
	 
 public static double newtonForwardDifferential(double x[], double y[][], double value, int n) {
		 double h = x[1] - x[0];
		 
		 double sum = y[0][0];
	     double u = (value - x[0]) / h;

	        for (int i = 1; i < n; i++) {
	            sum += (calculateUForward(u, i) * y[0][i]) / factorial(i);
	        }

	        return sum;
	 }
	 
	 
	 public static void runNewtonForward(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of data points: ");
	        int n = sc.nextInt();

	        double x[] = new double[n];
	        double y[][] = new double[n][n];

	        System.out.println("Enter the data points (x, y): ");
	        for (int i = 0; i < n; i++) {
	            x[i] = sc.nextDouble();
	            y[i][0] = sc.nextDouble();
	        }

	        // Calculating the forward difference table
	        for (int i = 1; i < n; i++) {
	            for (int j = 0; j < n - i; j++) {
	                y[j][i] = y[j + 1][i - 1] - y[j][i - 1];
	            }
	        }

	        System.out.print("Enter the value to interpolate: ");
	        double value = sc.nextDouble();

	        double result = newtonForward(x, y, value, n);
	        System.out.println("Interpolated value at " + value + " is " + result);
	        
	        sc.close();
	    }
	    
	 public static double newtonBackward(double x[], double y[][], double value, int n) {
	        double sum = y[n - 1][0];
	        double u = (value - x[n - 1]) / (x[1] - x[0]);

	        for (int i = 1; i < n; i++) {
	            sum += (calculateUBackward(u, i) * y[n - 1][i]) / factorial(i);
	        }

	        return sum;
	    }
	 
	
	 public static void runNewtonBackward(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of data points: ");
	        int n = sc.nextInt();

	        double x[] = new double[n];
	        double y[][] = new double[n][n];

	        System.out.println("Enter the data points (x, y): ");
	        for (int i = 0; i < n; i++) {
	            x[i] = sc.nextDouble();
	            y[i][0] = sc.nextDouble();
	        }

	        // Calculating the backward difference table
	        for (int i = 1; i < n; i++) {
	            for (int j = n - 1; j >= i; j--) {
	                y[j][i] = y[j][i - 1] - y[j - 1][i - 1];
	            }
	        }

	        System.out.print("Enter the value to interpolate: ");
	        double value = sc.nextDouble();

	        double result = newtonBackward(x, y, value, n);
	        System.out.println("Interpolated value at " + value + " is " + result);
	        
	        sc.close();
	    }
	
	public static void RaphsonIteration() {
		System.out.println("Hello World!");
	}
}
