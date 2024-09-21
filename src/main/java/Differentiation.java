import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Differentiation {

    // Function to differentiate a polynomial expression
    public static String differentiate(String expression) {
        // Pattern to match terms like 3*x^2, 5*x, 7, or x
    	expression = formatString(expression);
        Pattern pattern = Pattern.compile("([+-]?\\d*)\\*?(x(?:\\^(\\d+))?)?");
        Matcher matcher = pattern.matcher(expression);
        

        // Map to hold the differentiated terms
        Map<String, Integer> termMap = new HashMap<String, Integer>();
        int sign = 1;

        while (matcher.find()) {
            String coefficientStr = matcher.group(1);
            String variable = matcher.group(2);
            String exponentStr = matcher.group(3);
            
            if (!coefficientStr.equals("+") & !coefficientStr.equals("-") & coefficientStr != null & 
            		!coefficientStr.isEmpty() & variable == null & exponentStr == null ) {
            	continue;
            }
            if(coefficientStr.isEmpty() & variable == null & exponentStr == null) {
            	continue;
            }
            if (coefficientStr.equals("+")) {
            	sign = 1;
            	continue;
            }
            if (coefficientStr.equals("-")) {
            	sign = -1;
            	continue;
            }

            int coefficient = coefficientStr.isEmpty() ? 1 : Integer.parseInt(coefficientStr);
            int exponent = (exponentStr == null || exponentStr.isEmpty()) ? 1 :
                           Integer.parseInt(exponentStr);

            // Apply differentiation rules
            if (exponent == 0) {
                // Derivative of a constant is 0
                continue;
            }
            
            int newCoefficient = sign * coefficient * exponent;
            int newExponent = exponent - 1;

            // Construct the new term
            String newTerm = (newExponent == 0) ? String.valueOf(newCoefficient) :
                             (newExponent == 1) ? newCoefficient + "*x" :
                             newCoefficient + "*x^" + newExponent;
//            System.out.println(newTerm);
            // Add or combine the term
            termMap.put(newTerm, termMap.getOrDefault(newTerm, 0) + 1);
//            System.out.println(termMap);
            sign = 1;
        }

        // Combine like terms and format the result
        return combineLikeTerms(termMap);
    }
    
    public static String differentiate(String expression, char dependentVariable) {
        // Pattern to match terms like 3*x^2, 5*x, 7, or x
    	expression = formatString(expression);
        Pattern pattern = Pattern.compile("([+-]?\\d*)\\*?(x(?:\\^(\\d+))?)?".replace('x', dependentVariable));
        Matcher matcher = pattern.matcher(expression);
        

        // Map to hold the differentiated terms
        Map<String, Integer> termMap = new HashMap<String, Integer>();
        int sign = 1;

        while (matcher.find()) {
            String coefficientStr = matcher.group(1);
            String variable = matcher.group(2);
            String exponentStr = matcher.group(3);
            
            if (!coefficientStr.equals("+") & !coefficientStr.equals("-") & coefficientStr != null & 
            		!coefficientStr.isEmpty() & variable == null & exponentStr == null ) {
            	continue;
            }
            if(coefficientStr.isEmpty() & variable == null & exponentStr == null) {
            	continue;
            }
            if (coefficientStr.equals("+")) {
            	sign = 1;
            	continue;
            }
            if (coefficientStr.equals("-")) {
            	sign = -1;
            	continue;
            }

            int coefficient = coefficientStr.isEmpty() ? 1 : Integer.parseInt(coefficientStr);
            int exponent = (exponentStr == null || exponentStr.isEmpty()) ? 1 :
                           Integer.parseInt(exponentStr);

            // Apply differentiation rules
            if (exponent == 0) {
                // Derivative of a constant is 0
                continue;
            }
            
            int newCoefficient = sign * coefficient * exponent;
            int newExponent = exponent - 1;

            // Construct the new term
            String newTerm = (newExponent == 0) ? String.valueOf(newCoefficient) :
                             (newExponent == 1) ? newCoefficient + "*x".replace('x', dependentVariable) :
                             newCoefficient + "*x^".replace('x', dependentVariable) + newExponent;
//            System.out.println(newTerm);
            // Add or combine the term
            termMap.put(newTerm, termMap.getOrDefault(newTerm, 0) + 1);
//            System.out.println(termMap);
            sign = 1;
        }

        // Combine like terms and format the result
        return combineLikeTerms(termMap);
    }

    // Helper function to combine like terms
    private static String combineLikeTerms(Map<String, Integer> termMap) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Integer> entry : termMap.entrySet()) {
            String term = entry.getKey();
            int coefficient = entry.getValue();
            if (coefficient != 0) {
                if (result.length() > 0) {
                    result.append(" + ");
                }
                result.append(term);
            }
        }

        // Format result properly
        return result.toString().replaceAll("\\+ -", "- ");
    }
    
    private static String formatString(String expr) {
    	if (!expr.contains(" ")) {
    		expr = expr.replaceAll("\\+", " + ");
    		expr = expr.replaceAll("\\-", " - ");    		
    	}
//    	System.out.println("Formatted Expression " + expr);
    	return expr;
    }

    public static void testDifferentiation() {
//        String expression = "3*x^3 + 5*x^2 + 7*x + 2";
    	String expression = "2*x-3*x^2+x^3";
        System.out.println("Original Expression: " + expression);
        String derivative = differentiate(expression);
        System.out.println("Derivative: " + derivative);
    }
}
