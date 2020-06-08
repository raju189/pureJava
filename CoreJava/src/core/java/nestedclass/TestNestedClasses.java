package core.java.nestedclass;

public class TestNestedClasses {
	public static void main(String[] args) {
		// object create inner class public or default Same
		new A().new PublicInnerClass();

		// object create inner class protected
		new A().new ProtectedInnerClass();

		// object create inner class private
//		new A().new PrivateInnerClass(); not allowed private innerclass outside 
		// We should use factory method for this
		new A().instancePrivateInnerClass();

		// public static Nested class object creation
		new A.PubStaticC();

		// private static Nested class object creation
		A.instancePrivateStatic();

	}
}

class A {

	private static String staticPro;

	private String noStaticPro;

	private static void staticShow() {
		System.out.println("Static Show!");
	}

	public static PrivateStaticC instancePrivateStatic() {
		return new PrivateStaticC();
	}

	public PrivateInnerClass instancePrivateInnerClass() {
		return new PrivateInnerClass();
	}

	private void nonStaticShow() {
		System.out.println("Non Static");
	}

	protected class ProtectedInnerClass {

		public void runner() {
			// access non Static private member directly
			System.out.println(noStaticPro);
			nonStaticShow();

			// access Static private member directly
			System.out.println(staticPro);
			staticShow();
		}
	}

	private class PrivateInnerClass {
		public void runner() {
			// access non Static private member directly
			System.out.println(noStaticPro);
			nonStaticShow();

			// access Static private member directly
			System.out.println(staticPro);
			staticShow();
		}
	}

	public class PublicInnerClass {
		public void runner() {
			// access non Static private member directly
			System.out.println(noStaticPro);
			nonStaticShow();

			// access Static private member directly
			System.out.println(staticPro);
			staticShow();
		}
	}

	public static class PubStaticC {

		public void runner() {
			// not access non Static private member directly
//			System.out.println(noStaticPro);
//			nonStaticShow();

			// only access Static private member directly
			System.out.println(staticPro);
			staticShow();
		}
	}

	private static class PrivateStaticC {

		public void runner() {
			// not access non Static private member directly
//			System.out.println(noStaticPro);
//			nonStaticShow();

			// only access Static private member directly
			System.out.println(staticPro);
			staticShow();
		}
	}

}
