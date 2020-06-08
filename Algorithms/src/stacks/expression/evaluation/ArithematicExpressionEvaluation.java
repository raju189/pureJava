package stacks.expression.evaluation;

import java.util.Stack;

public class ArithematicExpressionEvaluation {

	public static void main(String[] args) {
		System.out.println(evaluation("(1+2) * ( 20 + 10) * (3)"));
	}

	private static double evaluation(String expression) {
		Stack<Character> ops = new Stack<>();
		Stack<Double> values = new Stack<>();
		String temp = "";

		expression = expression.replaceAll(" ", "");
		System.out.println("expression " + expression);
		for (int i = 0; i < expression.length(); i++) {
			char input = expression.charAt(i);

			switch (input) {
			case '(':
				break; // ignore (
			case ')':
				if (temp != "") {
					values.push(new Double(temp));
					temp = "";
				}
				doOperation(ops, values);
				break;
			case '+':
			case '*':
			case '%':
			case '/':
				ops.push(input);
				if (temp != "") {
					values.push(new Double(temp));
					temp = "";
				}
				break;
			default:
				temp += input + "";
			}
		}
		while(!ops.isEmpty()) {
			doOperation(ops, values);
		}
		return values.pop();
	}

	private static void doOperation(Stack<Character> ops, Stack<Double> values) {
		Character op = ops.pop();
		switch (op) {
		case '+':
			values.push(values.pop() + values.pop());
			break;
		case '*':
			values.push(values.pop() * values.pop());
			break;
		case '%':
			values.push(values.pop() % values.pop());
			break;
		case '/':
			values.push(values.pop() / values.pop());
			break;
		}
	}
}
