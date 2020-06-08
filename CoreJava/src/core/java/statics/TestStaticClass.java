package core.java.statics;

public class TestStaticClass {
	public static void main(String[] args) {
		// Instantion of Static InnerClass

		new SA.B().show();

		SA sa = new SA();

//		System.out.println(sa.new C());
		System.out.println(sa.instance());//Non public innerclass
	}
}

class SA {

	private static String parentName = "Outer";

	public static class B {
		private String childName = "Inner";

		public void show() {
			// static inner class allows only static members of outer class
			System.out.println("Static Parent Name:- " + parentName);
			System.out.println("Inner Name " + childName);
		}

	}

	private class C {
		
		public void show() {
			System.out.println(parentName);
		}
	}
	
	public C instance() {
		return new C();
	}
}
