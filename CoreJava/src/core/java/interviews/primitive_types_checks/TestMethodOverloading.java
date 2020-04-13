package core.java.interviews.primitive_types_checks;

/**
 * First check primitive itself to higher. Then check it's wrapper class type.
 * Then check Object class Then shows compiler error.
 * 
 * @author G_disgreat
 *
 */
public class TestMethodOverloading {
	public static void main(String[] args) {
		TestMethodOverloading test = new TestMethodOverloading();
		System.out.println("Calling with char A");
		// char -> int -> float -> double -> Character -> Object -> compiler error.
		test.show('A');

		System.out.println("Calling with 10");
		// int -> float -> double -> Integer -> Object -> compiler error
		test.show(10);

		System.out.println("Calling with 10.0f");
		// float -> double -> Float -> Object -> compiler error
		test.show(10.0f);

		System.out.println("Calling with 10.0d");
		// double -> Double -> Object -> compiler error
		test.show(10.0d);

		System.out.println("Calling with hello");
		// String -> Object
		test.show("hello");

		System.out.println("Calling with hello");
		// String -> Object
		test.show(new String("hello"));

	}

	void show(char a) {
		System.out.println("char");
	}

	void show(int i) {
		System.out.println("int");
	}

	void show(float f) {
		System.out.println("float");
	}

	void show(double d) {
		System.out.println("double");
	}

	void show(Integer i) {
		System.out.println("Integer");
	}

	void show(Double d) {
		System.out.println("Double");
	}

	void show(Float f) {
		System.out.println("Float");
	}

	void show(Character a) {
		System.out.println("Character");
	}

	void show(short a) {
		System.out.println("short");
	}

	void show(Short a) {
		System.out.println("Short Class");
	}

	void show(String s) {
		System.out.println("string");
	}

	void show(Object s) {
		System.out.println("Object");
	}

}
