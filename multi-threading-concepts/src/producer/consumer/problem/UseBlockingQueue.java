package producer.consumer.problem;

import java.time.Instant;
import java.util.concurrent.ArrayBlockingQueue;

public class UseBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

		new Thread(() -> {
			while (true) {
				try {
					arrayBlockingQueue.put("Item" + Instant.now());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}).start();

		new Thread(() -> {
			while (true) {
					String take;
					try {
						take = arrayBlockingQueue.take();
						System.out.println(take);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

		}).start();

		Thread.sleep(10000);
	}

}
