package core.java.serializations;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 1. Allow references classes of a class should be implemented Serializable
 * interface OR those properties should be transient, it's raise the Exception
 * java.io.NotSerializableException
 * 
 * @author G_disgreat
 *
 */
public class TestSerialization {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String fileName = new String("ser_basic.ser");

		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName))) {
			Plain before = new Plain("Hello", new PlainNonSer("Non Serialization"));
			Plain.staticValue = "before updating serialization  static value";
			stream.writeObject(before);
		}

		Plain.staticValue = "After updating serialization  static value";

		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName))) {
			Plain p = (Plain) stream.readObject();
			// try multiple time to read object got java.io.EOFException
//			System.out.println(stream.readObject());
			System.out.println(p);
		}

	}

}

class Plain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7645931137471312187L;

	private String name;

	private transient PlainNonSer nonSerRef;
	// transient is not effected on static props
	// static props are not instance variable scope.
	// it's get updated value recently.
	// It does not write in .ser file.
	public transient static String staticValue = "Intial value of Static";
	// transient is effected on final props.
	// these props are wrote in .ser file
	public transient final String finalVar;

	public Plain(String name, PlainNonSer nonSerRef) {
		this.name = name;
		this.nonSerRef = nonSerRef;
		this.finalVar = "final value";
	}

	@Override
	public String toString() {
		return "{ 'name':'" + name + "', 'nonSerRef':" + nonSerRef + ", 'staticValue':'" + staticValue
				+ "', 'finalVar':'" + finalVar + "'}";
	}
}

class PlainNonSer{
	private String name;

	public static String staticValue;

//	public PlainNonSer() {this.name = "test";}
	public PlainNonSer(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{ 'name':" + name + "}";
	}

}
