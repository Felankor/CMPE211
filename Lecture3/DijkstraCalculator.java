package Lecture3;
/**
 *
 * @author uzaycetin
 */
public class DijkstraCalculator {
    private Stack<Double> numbers = new Stack<Double>();   // Store numbers
    private Stack<String> operators = new Stack<String>(); // Store operators
    // We Consider 5 operators
    public boolean isOperator(String s){
        if ("+".equals(s)) return true;
        if ("-".equals(s)) return true;
        if ("/".equals(s)) return true;
        if ("*".equals(s)) return true;
        return "sqrt".equals(s);   
    }
    // Only sqrt operrates on one operand, others operate on two operands
    public double operate (String op, double num){
        if (op.equals("+")) return numbers.pop() + num; // Second operand is popped
        if (op.equals("-")) return numbers.pop() - num; // Second operand is popped
        if (op.equals("*")) return numbers.pop() * num; // Second operand is popped
        if (op.equals("/")) return numbers.pop() / num; // Second operand is popped
        if (op.equals("sqrt")) return Math.sqrt(num); // sqrt operrates on one operand  
        return -1;
    }
    // Requires an array of String for holding mixture of operands and operators
    public double calculate(String[] s){
        for (String item : s) {
            if ("(".equals(item)); // "(" is ignored
            else if (isOperator(item)) operators.push(item);
            else if (")".equals(item)) {
                double num = operate(operators.pop(), numbers.pop());
                numbers.push(num); 
            } else {
                numbers.push(Double.parseDouble(item));
            }
        }
        return numbers.pop();
    }
    public static void main(String [] args){
        String s = "( sqrt ( ( 1 + 2 ) * 3 ) + 7 ) )";
        String[] parts= s.split(" "); // String must be seperated by " "
        
        DijkstraCalculator Dijkstra = new DijkstraCalculator();
        System.out.println(Dijkstra.calculate(parts));
    }  
}
