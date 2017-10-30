package quiz2;

public class DijkstraCalculator {
	private Stack numbers = new Stack();
	private Stack operators = new Stack();

	public boolean isOperator(String s) {
		if ("+".equals(s))
			return true;
		if ("-".equals(s))
			return true;
		if ("/".equals(s))
			return true;
		if ("*".equals(s))
			return true;
		return false;
	}

	public double operate(String op, String num) {
		if (op.equals("+"))
			return Double.parseDouble(numbers.pop()) + Double.parseDouble(num);
		if (op.equals("-"))
			return Double.parseDouble(numbers.pop()) - Double.parseDouble(num);
		if (op.equals("*"))
			return Double.parseDouble(numbers.pop()) * Double.parseDouble(num);
		if (op.equals("/"))
			return Double.parseDouble(numbers.pop()) / Double.parseDouble(num);
		return -1;
	}

	public String calculate(String[] s) {
		for (String item : s) {
			if ("(".equals(item))
				;
			else if (isOperator(item))
				operators.push(item);
			else if (")".equals(item)) {
				double num = operate(operators.pop(), numbers.pop());
				numbers.push(num + "");
			} else {
				numbers.push(item);
			}
		}
		return numbers.pop();
	}

	public static void main(String[] args) {
		String s = "( ( ( 1 + 2 ) * 3 ) + 7 )";
		String[] parts = s.split(" ");

		DijkstraCalculator Dijkstra = new DijkstraCalculator();
		System.out.println(Dijkstra.calculate(parts));
	}
}