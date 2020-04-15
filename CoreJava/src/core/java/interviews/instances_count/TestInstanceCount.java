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

		// Ways to know type of instance
		EmployeeModel childToParent = modelChild1;

		System.out.println(" instance of direct parent :" + (model1 instanceof EmployeeModel));
		System.out.println(" instance of child to parent :" + (modelChild1 instanceof EmployeeModel));
		System.out.println(" getClass of child :" + (modelChild1.getClass()));
		System.out.println(" getClass of child to parent :" + (childToParent.getClass()));

		System.out.println(" isInstance() of class, direct parent :" + (EmployeeModel.class.isInstance(model1)));
		System.out.println(" isInstance() of class, child to parent :" + (EmployeeModel.class.isInstance(modelChild1)));

		
		/**
		 * instanceof, isInstance() are true: parent and child
		 * 
		 * getClass() is better to identify the class type.
		 */
		
	}

}
