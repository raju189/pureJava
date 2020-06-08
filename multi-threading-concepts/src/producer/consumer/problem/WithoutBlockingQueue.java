package producer.consumer.problem;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WithoutBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		MyBlockingQueue<String> queue = new MyBlockingQueue<>(10);

//		new Thread(() -> {
//			try {
//				while (true) {
//
//					System.out.println(queue.take());
//				}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}).start();
//
//		new Thread(() -> {
//			try {
//				while (true) {
//
//					queue.put("Item " + Instant.now());
//				}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}).start();
		ArrayList<String> list = new ArrayList<>();
		new Thread(new Producer(list)).start();

		new Thread(new Consumer(list)).start();

//		Thread.sleep(10000);

	}

	static class Producer implements Runnable {

		List<String> list;
		
		

		Producer(List<String> list) {
			this.list = list;
		}

		@Override
		public void run() {
			synchronized (list) {
				while (true) {

					for (int i = 0; i < 10; i++) {
						list.add("Item -" + Instant.now());
					}
					try {
						if (list.size() == 10) {
							list.wait();
							list.notifyAll();
						}
					} catch (InterruptedException e) {
					}

				}
			}

		}
	}

	static class Consumer implements Runnable {

		List<String> list;

		Consumer(List<String> list) {
			this.list = list;
		}

		@Override
		public void run() {

			synchronized (list) {
				while (true) {
					for (String i : list) {
						System.out.println(i);
					}
					list.clear();
					System.out.println(list.size());
					try {
						if (list.isEmpty()) {
							list.wait();
							list.notifyAll();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

}

class MyBlockingQueue<E> {
	private Queue<E> queue;
	private int max = 16;
	private ReentrantLock lock = new ReentrantLock(true);

	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	public MyBlockingQueue(int size) {

		queue = new LinkedList<>();
		this.max = size;
	}

	public void put(E e) throws InterruptedException {
		lock.lock();
		try {
			if (queue.size() == max) {
				notEmpty.await();
			}
			queue.add(e);
			notFull.signalAll();
		} finally {
			lock.unlock();
		}

	}

	public E take() throws InterruptedException {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				notFull.await();
			}
			E remove = queue.remove();
			notEmpty.signalAll();
			return remove;
		} finally {
			lock.unlock();
		}
	}

	public synchronized void putNotifyVersion(E e) throws InterruptedException {
		while (queue.size() == max) {
			notEmpty.await();
		}
		queue.add(e);
		notEmpty.notifyAll();

	}

	public synchronized E takeNotifyVersion() throws InterruptedException {
		while (queue.isEmpty()) {
			notFull.await();
		}
		E remove = queue.remove();
		notFull.notifyAll();
		return remove;
	}

}