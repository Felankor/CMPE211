package quizCozumler;

public class ResizableStack {
	
	int[] stack;
	int current;
	
	public ResizableStack(){
		current=0;
		stack= new int[1];
	}
	
	public boolean isEmpty(){
		return current==0;
	}
	
	public int size(){
		return current;
	}
	
	public void resize(int newSize){	//if stack is full, double the size
		int[] temp = new int[newSize];	//if current is equal to stack.length/4, halve the size
		for (int i = 0; i < current; i++) {
			temp[i] = stack[i];
		}
		stack = temp;				
	}
	
	public void push(int item) {
		if (current == stack.length) {	//if stack is full, double the size
			resize(2 * stack.length);
		}
		stack[current++] = item;
	}

	public int pop() {
		int item = stack[--current];
		if (current > 0 && current == stack.length / 4) {	//if current is equal to stack.length/4, halve the size
			resize(stack.length / 2);						//so we have space to add items
		}
		return item;
	}
	
	public void display(){
		System.out.println("-------------------------");
		for (int i = 0; i < current; i++) {
			System.out.print(" " + stack[i]);
		}
		System.out.println();
		System.out.println("-------------------------");
	}
	
	public static void main(String[] args) {
		ResizableStack s= new ResizableStack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.pop();
		s.pop();
		s.pop();
		s.display();
		System.out.println(s.stack.length);
	}

}
