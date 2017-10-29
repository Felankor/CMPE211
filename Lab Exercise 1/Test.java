import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {

		int[] arr = getData();

		StopWatch watchTS = new StopWatch();
		System.out.println("ThreeSum count: " + ThreeSum.count(arr));
		System.out.println("ThreeSum elapsed time: " + watchTS.elapsedTime());

		System.out.println();

		StopWatch watchTSF = new StopWatch();
		System.out.println("ThreeSumFast count: " + ThreeSumFast.count(arr));
		System.out.println("ThreeSumFast elapsed time: " + watchTSF.elapsedTime());
	}

	/*
	 * DATASETS
	 * 
	 * https://algs4.cs.princeton.edu/14analysis/1Kints.txt
	 * https://algs4.cs.princeton.edu/14analysis/2Kints.txt
	 * https://algs4.cs.princeton.edu/14analysis/4Kints.txt
	 * https://algs4.cs.princeton.edu/14analysis/8Kints.txt
	 * https://algs4.cs.princeton.edu/14analysis/16Kints.txt
	 * https://algs4.cs.princeton.edu/14analysis/32Kints.txt
	 * https://algs4.cs.princeton.edu/14analysis/1Mints.txt
	 * 
	 */

	public static int[] getData() throws IOException {
		URL textURL = new URL("https://algs4.cs.princeton.edu/14analysis/2Kints.txt");
		Scanner scanner = new Scanner(new InputStreamReader(textURL.openStream()));

		// change the size of arr when you change the URL
		int[] arr = new int[2000];
		int i = 0;

		while (scanner.hasNext()) {
			arr[i++] = scanner.nextInt();
		}

		scanner.close();

		return arr;
	}
}
