package core.java.statics;

/**
 * 
 * @author G_disgreat
 * 
 *         Parent has public static members and attributes.
 * 
 *         case 1: child has same static members and attributes then it's always
 *         called it's own members. case 2: child has no same static members or
 *         attributes then it's always called parent members by instance case 3:
 *         child instance assign to parent reference then it's always called
 *         parent members
 * 
 *         Note: by ClassName, always called it's own members if child is
 *         override static members
 * 
 *         By ClassName, always called parent if child is not override static
 *         members
 * 
 */

class A {
	public static String staticHello = "Static Parent!";

	public static void staticShow() {
		System.out.println("Static Show Parent!");
	}
}

class B extends A {
	public static String staticHello = "Static Child!";

	public static void staticShow() {
		System.out.println("Static Show Parent!");
	}

}

public class TestStaticMembers {

	public static void main(String[] args) {

		A a = new B();
		System.out.println(a.staticHello);// It's called parent
		a.staticShow(); // It's called parent

		System.out.println(B.staticHello); // It's called child when static attribute override otherwise parent
		B.staticShow(); // It's called child when static method override otherwise parent
	}
}
