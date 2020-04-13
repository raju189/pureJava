package core.java.interviews.equals_check;

/**
 * primitive == primitive -> true;
 * primitive equals primitive -> true; 
 * primitive == reference -> false;
 * primitive equals reference -> true 
 * refernce == reference -> false
 * referenc equals reference -> true
 * 
 * @author G_disgreat
 *
 */
public class TestEqualsCheck {
	public static void main(String[] args) {
		String pStr = "Hello";
		String pStr2 = "Hello";

		String rStr = new String("Hello");

		String rStr2 = new String("Hello");

		System.out.println("primitive == primitive     " + (pStr == pStr));

		System.out.println("primitive equals primitive     " + (pStr.equals(pStr)));

		System.out.println("primitive == reference     " + (pStr == rStr));

		System.out.println("primitive equals reference     " + (pStr.equals(rStr)));

		System.out.println("refernce == reference     " + (rStr == rStr2));

		System.out.println("referenc equals reference     " + (rStr.equals(rStr2)));
	}
}
