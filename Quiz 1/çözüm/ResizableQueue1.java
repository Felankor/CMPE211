package quizCozumler;

public class ResizableQueue1 {

	int[] queue;
	int end;

	public ResizableQueue1(int capacity) {
		end = 0;
		queue = new int[capacity];
	}

	public void add(int item) {
		if (end == queue.length) {
			resize(2 * queue.length);
		}
		queue[end] = item;
		end++;
	}

	public int remove() {
		if (end == 0) {
			System.out.println("Queue is empty. Can't delete.");
			return -1;
		}
		int item = queue[0];
		for (int i = 1; i < queue.length; i++) {
			queue[i - 1] = queue[i];
		}
		end--;

		if (end > 0 && end == queue.length / 4) { // if current is equal to
													// stack.length/4, halve the
													// size
			resize(queue.length / 2); // so we have space to add items
		}

		return item;
	}

	public void display() {
		System.out.println("-------------------------");
		for (int i = 0; i < end; i++) {
			System.out.print(" " + queue[i]);
		}
		System.out.println();
		System.out.println("-------------------------");
	}

	public void resize(int newSize) { // if stack is full, double the size
		int[] temp = new int[newSize]; // if current is equal to stack.length/4,
										// halve the size
		for (int i = 0; i < end; i++) {
			temp[i] = queue[i];
		}
		queue = temp;
	}

	public static void main(String[] args) {
		ResizableQueue1 q = new ResizableQueue1(1);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.remove();
		q.remove();
		q.remove();
		q.display();
		System.out.println(q.queue.length);
	}
}
