

public class Main {

	public static void main(String[] args) {
//		AlgebraicExpansion.testExpansion();
//		EvaluateExpression.testEvaluate();
//		Differentiation.testDifferentiation();
//		UValueGenerator.testUvalueGenerator();
//		String u = UValueGenerator.generateTerm(3);
//		System.out.println(u);
//		String e = AlgebraicExpansion.expandExpression(u);
//		System.out.println(e);
//		String d = Differentiation.differentiate(e, 'u');
//		System.out.println(d);
//		double answer = EvaluateExpression.evaluateExpression(d, 2, "u");
//		System.out.println(answer);
		
		double x[] = {1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6};
        double y[][] = {{7.989, 0, 0, 0, 0, 0, 0},{8.403,0,0,0,0,0,0},{8.781,0,0,0,0,0,0},
        		{9.129,0,0,0,0,0,0},{9.451,0,0,0,0,0,0},{9.750,0,0,0,0,0,0},{10.031,0,0,0,0,0,0}};

//        System.out.println("Enter the data points (x, y): ");
//        for (int i = 0; i < n; i++) {
//            x[i] = sc.nextDouble();
//            y[i][0] = sc.nextDouble();
//        }
        
//        for (int i = 0; i < 7; i++) {
//        	for (int j = 0; j < 7; j++) {
//        		System.out.print(y[i][j]);
//        		System.out.print("   ");
//        	}
//        	System.out.println(" ");
//        }
//        
//        System.out.println("");

        // Calculating the forward difference table
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 7 - i; j++) {
                y[j][i] = y[j + 1][i - 1] - y[j][i - 1];
            }
        }
        
//        for (int i = 0; i < 7; i++) {
//        	for (int j = 0; j < 7; j++) {
//        		System.out.print(y[i][j]);
//        		System.out.print("   ");
//        	}
//        	System.out.println(" ");
//        }

//        System.out.print("Enter the value to interpolate: ");
        double value = 1.1;
//
        double result = Newton.newtonForwardDifferential(x, y, value, 7);
        System.out.println("The result is: " + result);
	}
}
