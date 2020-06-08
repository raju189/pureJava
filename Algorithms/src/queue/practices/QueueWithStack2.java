package queue.practices;

import java.util.Stack;

/**
 * 
 * @author G_disgreat
 * 
 *         enQueue(q, x) 1) Push x to stack1 (assuming size of stacks is
 *         unlimited). Here time complexity will be O(1)
 * 
 *         deQueue(q) 1) If both stacks are empty then error. 2) If stack2 is
 *         empty While stack1 is not empty, push everything from stack1 to
 *         stack2. 3) Pop the element from stack2 and return it. Here time
 *         complexity will be O(n)
 *
 */
public class QueueWithStack2 {

	static class Queue {
		Stack<Integer> stack1;
		Stack<Integer> stack2;

		static void push(Stack<Integer> topRef, int newData) {
			topRef.push(newData);
		}

		static int pop(Stack<Integer> topRef) {
			if (topRef.isEmpty()) {
				System.out.println("Stack Underflow");
				System.exit(0);
			}

			return topRef.pop();
		}

		static void enQueue(Queue q, int x) {
			push(q.stack1, x);
		}

		static int deQueue(Queue q) {
			int x;

			if (q.stack1.isEmpty() && q.stack2.isEmpty()) {
				System.out.println("Queue is empty!");
				System.exit(0);
			}

			if (q.stack2.isEmpty()) {
				while (!q.stack1.isEmpty()) {
					x = pop(q.stack1);
					push(q.stack2, x);
				}
			}
			x = pop(q.stack2);
			return x;
		}
	}

	public static void main(String[] args) {

		Queue q = new Queue();
		q.stack1 = new Stack<>();
		q.stack2 = new Stack<>();
		Queue.enQueue(q, 1);
		Queue.enQueue(q, 2);
		Queue.enQueue(q, 3);

		/* Dequeue items */
		System.out.print(Queue.deQueue(q) + " ");
		System.out.print(Queue.deQueue(q) + " ");
		System.out.println(Queue.deQueue(q) + " ");
	}

}
