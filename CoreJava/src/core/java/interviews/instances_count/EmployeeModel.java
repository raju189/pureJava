package core.java.interviews.instances_count;

/**
 * counter should be increment in reference block instead of constructor. Before
 * increment count, should check whether it's called by child constructor.
 * 
 * @author G_disgreat
 *
 */
public class EmployeeModel {

	private static int staticBlockCount = 0;
	private static int referenceBlockCount = 0;
	private static int constructorCount = 0;
	private String name;
	private String id;
	static {
		staticBlockCount = getStaticBlockCount() + 1;
	}

	{
		if (EmployeeModel.class.equals(this.getClass()))
			referenceBlockCount = getReferenceBlockCount() + 1;
	}

	public EmployeeModel() {
		if (EmployeeModel.class.equals(this.getClass()))
			constructorCount = getConstructorCount() + 1;
	}

	public EmployeeModel(String name, String id) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static int getStaticBlockCount() {
		return staticBlockCount;
	}

	public static int getReferenceBlockCount() {
		return referenceBlockCount;
	}

	public static int getConstructorCount() {
		return constructorCount;
	}

	@Override
	protected void finalize() throws Throwable {
		if (EmployeeModel.class.equals(this.getClass()))
			referenceBlockCount = getReferenceBlockCount() - 1;
	}
}
