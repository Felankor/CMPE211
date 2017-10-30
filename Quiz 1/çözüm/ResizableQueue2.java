package quizCozumler;
import java.util.Arrays;

public class ResizableQueue2 {

	int[] queue;
	int start, end, size;

	public ResizableQueue2(int capacity) {
		queue = new int[capacity];
		start = 0;
		end = 0;
		size = 0;
	}

	public void resize(int newCapacity) {
		int[] temp = new int[newCapacity];
		for (int i = 0; i < size; i++) {
			temp[(i + start) % newCapacity] = queue[(i + start) % queue.length];
		}
		queue = temp;
	}

	public void enqueue(int n) {
		if (size == queue.length) {
			resize(2 * queue.length);
		}
		queue[end % queue.length] = n;
		end++;
		size++;
	}

	public int dequeue() {
		if (size == 0) {
			System.out.println("nothing to delete");
			return Integer.MIN_VALUE;
		}
		int result = queue[start];
		start++;
		start = start % queue.length;
		size--;
		if (size > 0 && size == queue.length / 4) {
			resize(queue.length / 2);
		}
		return result;
	}

	public void display() {
		System.out.print("QUEUE: ");
		for (int i = 0; i < size; i++) {
			System.out.print(queue[(i + start) % queue.length] + " ");
		}
		System.out.println();
//		System.out.println(Arrays.toString(queue));
	}

	public static void main(String[] args) {
		ResizableQueue2 q = new ResizableQueue2(1);
		q.enqueue(1);
		q.display();

		q.enqueue(2);
		q.display();
		q.enqueue(3);
		q.display();
		q.enqueue(4);
		q.display();
		q.enqueue(5);
		q.display();
		q.dequeue();
		q.display();
		q.dequeue();
		q.display();

		q.dequeue();
		q.display();
		q.dequeue();
		q.display();

		 q.dequeue();
		 q.dequeue();
		 q.dequeue();

		q.display();
	}
}
