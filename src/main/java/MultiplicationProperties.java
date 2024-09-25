public class MultiplicationProperties {
    public static void main(String[] args) {
        // Input values with uncertainties
        double a = 2.0; // value of a
        double da = 0.1; // uncertainty in a
        double b = 3.0; // value of b
        double db = 0.2; // uncertainty in b
        double c = 4.0; // value of c
        double dc = 0.3; // uncertainty in c
        
        // Calculate the product and uncertainty using multiplication properties
        double product = a * b * c;
        double uncertainty = Math.abs(a * b) * dc + Math.abs(a * c) * db + Math.abs(b * c) * da;
        
        System.out.println("Product: " + product);
        System.out.println("Uncertainty: " + uncertainty);
    }
}