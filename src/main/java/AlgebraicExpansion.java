import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;

public class AlgebraicExpansion {

    // Function to expand a polynomial expression like p(p-1)(p-2)
	public static String expandExpression(String expression) {
		String returnValue = "";
	try {
        ExprEvaluator util = new ExprEvaluator();
        IExpr expr = util.eval(expression);

        IExpr result = util.eval(F.Distribute(expr));
        // print: a*b+a*c

        result = util.eval(F.Expand(expr));
        // print: a*b+a*c
        returnValue = result.toString();
	} catch (Exception e) {
        e.printStackTrace();
    }
	return returnValue;
}

    public static void testExpansion() {
        // Example usage
        String expression = "p*(p-1)*(p-2)";
        String expanded = expandExpression(expression);
        System.out.println("Original Expression: " + expression);
        System.out.println("Expanded Expression: " + expanded);
    }
}
