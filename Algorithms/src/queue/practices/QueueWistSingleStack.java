package queue.practices;

import java.util.Stack;

/**
 * 
 * @author G_disgreat enQueue(x) 1) Push x to stack1.
 * 
 *         deQueue: 1) If stack1 is empty then error. 2) If stack1 has only one
 *         element then return it. 3) Recursively pop everything from the
 *         stack1, store the popped item in a variable res, push the res back to
 *         stack1 and return res
 */
public class QueueWistSingleStack {

	static class Queue {

		private Stack<Integer> stack;

		public Queue(Stack<Integer> stack) {
			this.stack = stack;
		}

		private void push(int newData) {
			stack.push(newData);
		}

		public void enQueue(int newData) {
			push(newData);
		}

		private int pop() {
			/* If stack is empty then error */
			if (stack.isEmpty()) {
				System.out.println("Stack Underflow");
				System.exit(0);
			}
			// return element from stack
			return stack.pop();
		}

		public int deQueue() {
			int x, res = 0;
			if (stack.isEmpty()) {
				System.out.println("Q is Empty");
				System.exit(0);
			} else if (stack.size() == 1) {
				return pop();
			} else {
				x = pop();
				res = deQueue();
				push(x);
			}

			return res;
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue(new Stack<>());

		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);

		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}

}
