package quizCozumler;

// 1 1 2 3 5 8 13 21 34 
public class Fibonacci {

	public Fibonacci() {

	}

	// iterative
	public long fib1(int n) {
		long secondPrev = 1;
		long firstPrev = 1;
		long result = 0;
		for (int i = 2; i <= n; i++) {
			result = firstPrev + secondPrev;
			secondPrev = firstPrev;
			firstPrev = result;
		}

		return result;

	}

	// recursive
	public long fib2(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return fib2(n - 1) + fib2(n - 2);
		}
	}

	// memoized

	// initializations
	long[] fibArray;

	public Fibonacci(int n) {
		fibArray = new long[n + 1]; // +1 because this array also holds nth fib
									// number
		for (int i = 0; i < fibArray.length; i++) {
			fibArray[i] = -1;
		}
		fibArray[0] = 1;
		fibArray[1] = 1;

	}

	public long fib3(int n) {
		if (fibArray[n] != -1) { // we have our value, don't calculate it
			return fibArray[n];
		}
		fibArray[n] = fib3(n - 1) + fib3(n - 2);
		return fibArray[n];
	}

	public static void main(String[] args) {
		int n=45;
		Fibonacci test = new Fibonacci();
		Fibonacci testMemo = new Fibonacci(n);
		
		StopWatch watch1 = new StopWatch();
		test.fib1(n);
		System.out.printf("%.5f", watch1.elapsedTime());
		System.out.println();

		StopWatch watch2 = new StopWatch();
		test.fib2(n);
		System.out.printf("%.5f", watch2.elapsedTime());
		System.out.println();

		StopWatch watch3 = new StopWatch();
		testMemo.fib3(2);
		System.out.printf("%.5f", watch3.elapsedTime());
		System.out.println();
	}

}
