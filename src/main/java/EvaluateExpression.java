import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class EvaluateExpression{

    // Function to evaluate a mathematical expression with a given value of x
    public static double evaluateExpression(String expression, double xValue, String independentVariable) {
        // Replace all instances of 'x' in the expression with the given value
        expression = expression.replace(independentVariable, String.valueOf(xValue));

        try {
            // Create an expression object using exp4j
            Expression expr = new ExpressionBuilder(expression)
                    .build();
            
            // Evaluate the expression and return the result
            return expr.evaluate();
        } catch (Exception e) {
            System.err.println("Error evaluating expression: " + e.getMessage());
            return Double.NaN;
        }
    }

    public static void testEvaluate() {
//        String expression = "3*x^3 + 5*x^2 + 7*x + 2";
        String expression = "-1 + 2*u";
        double xValue = 0; // Example value for x
        
        double result = evaluateExpression(expression, xValue, "u");
        System.out.println("Original Expression: " + expression);
        System.out.println("Value of x: " + xValue);
        System.out.println("Result: " + result);
    }
}
