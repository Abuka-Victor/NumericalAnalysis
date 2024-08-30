public class UValueGenerator {

    // Function to generate algebraic terms with u
    public static String generateTerm(int termNumber) {
        if (termNumber <= 0) {
            return "1";
        }
        
        StringBuilder result = new StringBuilder();
        
        // Generate the term based on the term number
        result.append("u");
        for (int i = 1; i < termNumber; i++) {
            if (i > 0) {
                result.append("*");
            }
            if (i > 0) {
                result.append("(").append("u").append("-");
                result.append(i).append(")");
            }
        }
        
        return result.toString();
    }

    public static void testUvalueGenerator() {
        // Example usage
        for (int i = 1; i <= 4; i++) {
            System.out.println("Term " + i + ": " + generateTerm(i));
        }
    }
}
