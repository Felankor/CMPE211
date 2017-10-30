package quizCozumler;

import java.util.Random;

public class Queue2 {

	int[] queue;
	int start, end, size;

	public Queue2(int capacity) {
		start = 0;
		end = 0;
		size = 0;
		queue = new int[capacity];
	}

	public void add(int item) {
		if (size == queue.length) {
			System.out.println("Queue is full. Can't add.");
			return;
		}
		queue[end % queue.length] = item;
		end++;
		size++;
	}

	public int remove() {
		if (size == 0) {
			System.out.println("Queue is empty. Can't delete.");
			return -1;
		}

		int item = queue[start];
		start++;
		start = start % queue.length;
		size--;
		return item;
	}
	
	public void display() {
		System.out.println("-------------------------");
		for (int i = 0; i < size; i++) {
            System.out.print(" " + queue[(start+i)%queue.length]);
		}
		System.out.println();
		System.out.println("-------------------------");
	}
	
	public void fillQueue(){
		Random r= new Random();
		for(int i=0;i<queue.length;i++){
			queue[i]=r.nextInt();
		}
	}
	
	public static void main(String[] args) {
		int n=99999999;
		Queue2 q= new Queue2(n);
		q.fillQueue();
////		q.remove();
//		q.add(1);
//		q.add(2);
//		q.add(3);
////		q.add(4);
////		q.display();
//		q.remove();
//		q.display();
		StopWatch watch= new StopWatch();
		q.remove();
		System.out.println(watch.elapsedTime());
	}
}
