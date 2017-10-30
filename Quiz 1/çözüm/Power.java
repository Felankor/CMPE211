package quizCozumler;

public class Power {
	/*
	 * 2^5 = 2*2^4 = 2*(2*2^3) = 2*(2*(2*(2^2))) = 2*(2*(2*(2*(2^1))) =
	 * 2*(2*(2*(2*(2*(2^0))))) = 2*2*2*2*2*1 = 32
	 */
	public long power1(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		} else {
			return base * power1(base, exponent - 1);
		}
	}

	/*
	 * 2^5 = 2*2^4 = 2*((2^2)*(2^2)) = 2*((2*(2^1))*(2*(2^1))) =
	 * 2*((2*(2*(2^0)))*(2*(2*(2^0))) = 2*((2*(2*(2^0))))*(2*(2*(2^0))))) =
	 * 2*((2*(2*1)))*(2*(2*1)))) = 2*(2*2*2*2) = 32
	 */
	public long power2(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		}

		if (exponent % 2 == 0) {
			return power2(base, exponent / 2) * power2(base, exponent / 2);
		} else {
			return base * power2(base, exponent / 2) * power2(base, exponent / 2);
		}

	}

	public long power3(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		long p = power2(base, exponent / 2);
		if (exponent % 2 == 0) {
			return p * p;
		} else {
			return base * p * p;
		}

	}

	public static void main(String[] args) {
		Power test = new Power();
		StopWatch watch1 = new StopWatch();
		test.power1(999999999, 9999);
		System.out.printf("%.5f", watch1.elapsedTime());
		System.out.println();

		StopWatch watch2 = new StopWatch();
		test.power2(999999999, 999999999);
		System.out.printf("%.5f", watch2.elapsedTime());
		System.out.println();

		StopWatch watch3 = new StopWatch();
		test.power3(999999999, 999999999);
		System.out.printf("%.5f", watch3.elapsedTime());
		System.out.println();
	}

}
