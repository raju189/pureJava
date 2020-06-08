package interview.problems;

import java.util.stream.IntStream;

public class PrintEvenOddNumberSequence {

	public static void main(String[] args) {
		int range = 100;
		new Thread(() -> {
			IntStream.range(0, range).forEach(i -> {
				if (i % 2 == 0) {
					System.out.println(i +" is Even");
					
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}).start();

		new Thread(() -> {
			IntStream.range(0, range).forEach(i -> {
				if (i % 2 != 0) {
					System.out.println(i+" is ODD");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}).start();
	}

}
