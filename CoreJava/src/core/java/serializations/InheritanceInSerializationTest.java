package core.java.serializations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class InheritanceInSerializationTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fileName = new String("ser_inheritance.ser");

		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName))) {

			// 1. child is serializable but base not, create child object and assign to
			// base, then do serialization it's work but base props are not serialized.
//			BaseNonSer b = new Child();
//			b.setSecond("Second");
//			stream.writeObject(b); //name = Child:: Base Second prop =null

			//If Base is serializable then all child classes are serialzable so it's work properly.
			Base b = new Child("Child");
			b.setSecond("Second");
			stream.writeObject(b); //name =Child:: Base Second prop =Second
		}

		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName))) {
			System.out.println(stream.readObject());
		}
	}
}

class BaseNonSer {
	private String name;
	String second;

	@Override
	public String toString() {
		return "name =" + name;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}
}

class Base implements Serializable {
	private String name;
	String second;

	@Override
	public String toString() {
		return "name =" + name;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}
}

class Child extends Base {
	private String name;

	public Child(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name =" + getName() + ":: Base Second prop =" + super.second;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}