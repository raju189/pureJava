package core.java.interfaces;

interface I {
	void show();
	
	default void defaultShow() {
		System.out.println("Default Show!");
	}
	
	static void staticShow() {
		System.out.println("static show!");
	}
}

public class AITest implements I{

	@Override
	public void show() {
		System.out.println("Show!");
	}
	
	public static void main(String[] args) {
		I i = () -> System.out.println("Lamda implementation!");
		
		i.defaultShow();
//		i.staticShow(); We can access static method my reference
		I.staticShow();
	}
	
	
}
