package core.java.serializations;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternilizationTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fileName = new String("externalization_test.txt");

		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName))) {
			PlainExt before = new PlainExt();
			before.setName("Name");
			before.setQualification("qualification");
			stream.writeObject(before);
		}

		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName))) {
			PlainExt p = (PlainExt) stream.readObject();
			System.out.println("name =" + p.getName());
		}
	}

}

class PlainExt implements Externalizable {

	private String name;
	private String qualification;

	// Mandatory
	// otherwise java.io.InvalidClassException:
	// core.java.serializations.PlainExt; no valid constructor
	public PlainExt() {

	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(getName());
		out.writeObject(getQualification());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		//should follow same order write props in writeExternal method.
		name = (String) in.readObject();
		qualification = (String) in.readObject();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

}
