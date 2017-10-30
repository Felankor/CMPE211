package quizCozumler;

import java.util.Random;

public class Queue1 {

	int[] queue;
	int end;

	public Queue1(int capacity) {
		end = 0;
		queue = new int[capacity];
	}

	public void add(int item) {
		if (end == queue.length) {
			System.out.println("Queue is full. Can't add.");
			return;
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
	
	public void fillQueue(){
		Random r= new Random();
		for(int i=0;i<queue.length;i++){
			queue[i]=r.nextInt();
		}
	}

	public static void main(String[] args) {
		int n=99999999;
		Queue1 q = new Queue1(n);
		q.fillQueue();
//		q.display();
//		q.remove();
//		q.add(1);
//		q.add(2);
//		q.add(3);
//		q.display();
//		q.remove();
//		q.display();
		StopWatch watch= new StopWatch();
		q.remove();
		System.out.println(watch.elapsedTime());
	}

}
