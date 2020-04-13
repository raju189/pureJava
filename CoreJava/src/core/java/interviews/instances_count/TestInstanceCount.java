package core.java.interviews.instances_count;

/**
 * Best Approach, to use reference block and checking not called by child
 * constructor, use static counter variable
 * 
 * @author G_disgreat
 *
 */
public class TestInstanceCount {

	public static void main(String[] args) {
		EmployeeModel model1 = new EmployeeModel();
		EmployeeModel model2 = new EmployeeModel();
		EmployeeModel model3 = new EmployeeModel();

		System.out.println("static block count :" + EmployeeModel.getStaticBlockCount());
		System.out.println("reference block count :" + EmployeeModel.getReferenceBlockCount());
		System.out.println("constructor count :" + EmployeeModel.getConstructorCount());

		EmployeeModelChild modelChild1 = new EmployeeModelChild();

		System.out.println(":::: After child instancation::::");
		System.out.println("static block count :" + EmployeeModel.getStaticBlockCount());
		System.out.println("reference block count :" + EmployeeModel.getReferenceBlockCount());
		System.out.println("constructor count :" + EmployeeModel.getConstructorCount());

		model3 = null;
		Runtime.getRuntime().gc();
		System.out.println(":::: After calling GC::::");
		System.out.println("static block count :" + EmployeeModel.getStaticBlockCount());
		System.out.println("reference block count :" + EmployeeModel.getReferenceBlockCount());
		System.out.println("constructor count :" + EmployeeModel.getConstructorCount());

	}

}
