package quiz2;

public class Stack {

	private String stack[];
	private int current;

	public Stack() {
		stack = new String[1];
		current = 0;
	}

	public void resize(int newCapacity) {
		String[] temp = new String[newCapacity];
		for (int i = 0; i < current; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}

	public boolean isEmpty() {
		return current == 0;
	}

	public int size() {
		return current;
	}

	public void push(String item) {
		if (current == stack.length) {
			resize(2 * stack.length);
		}
		stack[current] = item;
		current++;
	}

	public String pop() {
		if (current == 0) {
			return null;
		}
		current--;
		if (current > 0 && current == stack.length / 4) {
			resize(stack.length / 2);
		}
		return stack[current];
	}

	public String toString() {
		String ret = "";
		for (int i = 0; i < current; i++) {
			ret += (stack[i] + " ");
		}
		return ret;
	}

}
